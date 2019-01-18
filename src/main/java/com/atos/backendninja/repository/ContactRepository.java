package com.atos.backendninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.backendninja.entity.Contact;



@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

	public Contact findById(int id);

}