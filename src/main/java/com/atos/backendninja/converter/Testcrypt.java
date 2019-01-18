package com.atos.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testcrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));

	}

}
