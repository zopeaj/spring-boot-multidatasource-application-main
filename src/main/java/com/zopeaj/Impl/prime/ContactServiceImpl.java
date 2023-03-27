package com.zopeaj.Impl.prime;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zopeaj.model.prime.Contact;
import com.zopeaj.service.prime.IContactService;

@Service 
public class ContactServiceImpl implements IContactService{

	@Override
	public Contact getContactByEmail(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact updateContactById(UUID id, String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContactById(UUID id) {
		// TODO Auto-generated method stub
		
	}
}
