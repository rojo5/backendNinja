package com.atos.backendninja.component;

import org.springframework.stereotype.Component;

import com.atos.backendninja.entity.Contact;
import com.atos.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {

	/**
	 * Convert 2 entity.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact convert2Entity(ContactModel contactModel) {
		return new Contact(contactModel.getId(), contactModel.getFirstname(), contactModel.getLastname(),
				contactModel.getTelephone(), contactModel.getCity());
	}


	/**
	 * Convert 2 contact model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel convert2ContactModel(Contact contact) {
		return new ContactModel(contact.getId(), contact.getFirstname(), contact.getLastname(),
				contact.getTelephone(), contact.getCity());
	}

}