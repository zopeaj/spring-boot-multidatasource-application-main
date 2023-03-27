package com.zopeaj.service.prime;

import java.util.*;

import org.springframework.stereotype.Component;

import com.zopeaj.model.prime.Contact; 

@Component
public interface IContactService {
	public Contact createContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(UUID id);
	public void deleteContactById(UUID id);
	public Contact getContactByEmail(String address);
	public Contact updateContactById(UUID id, String address);
}
