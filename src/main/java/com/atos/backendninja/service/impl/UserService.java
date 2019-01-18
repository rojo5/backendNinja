package com.atos.backendninja.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atos.backendninja.entity.UserRole;
import com.atos.backendninja.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		com.atos.backendninja.entity.User user = userRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = buildAutorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	private User buildUser(com.atos.backendninja.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassoword(), user.isEnable(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAutorities(Set<UserRole> userRoles){
		return userRoles.stream().map((UserRole userRole) -> new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toList());
	}


}
