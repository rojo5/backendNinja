package com.atos.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atos.backendninja.component.ContactConverter;
import com.atos.backendninja.entity.Contact;
import com.atos.backendninja.model.ContactModel;
import com.atos.backendninja.repository.ContactRepository;
import com.atos.backendninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convert2Entity(contactModel));
		return contactConverter.convert2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContact() {

		return contactRepository
				.findAll()
				.stream()
				.map((Contact contact)->contactConverter.convert2ContactModel(contact))
				.collect(Collectors.toList());
	}

	@Override
	public ContactModel findContactById(int id) {
		return contactConverter.convert2ContactModel(contactRepository.findById(id));
	}

	@Override
	public void removeContact(int id) {
		contactRepository.deleteById(id);
	}

}
