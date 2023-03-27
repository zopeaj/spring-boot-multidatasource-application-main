package com.zopeaj.repository.prime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import jakarta.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zopeaj.model.prime.Contact;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class ContactRepository {
	
	@PersistenceContext(name="primedbContext")
	private EntityManager entityManager;
	
	@Transactional
	public Contact save(Contact contact) {
		entityManager.persist(contact);
		return contact; 
	}
	
	public List<Contact> findAll() {
		String jpql = "SELECT c FROM Contact c";
		TypedQuery<Contact> query = entityManager.createQuery(jpql, Contact.class);
		return query.getResultList();
	}
	
	public Contact findById(UUID id) {
		return entityManager.find(Contact.class, id);
	}
	
	public void deleteContact(UUID id) {
		Contact contact = entityManager.find(Contact.class, id);
		entityManager.remove(contact);
	}
	
	public Contact getContactByEmail(String address) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
		Root<Contact> contactRoot = cq.from(Contact.class);
		cq.select(contactRoot).where(cb.equal(contactRoot.get("address"), address));
		TypedQuery<Contact> contactResult = entityManager.createQuery(cq);
		Contact contact = contactResult.getSingleResult();
		return contact;
	}
	
	public Contact updateContactById(UUID id, String address) {
		Contact contactToUpdate = entityManager.find(Contact.class, id);
		if (contactToUpdate != null) {
			contactToUpdate.setAddress(address);
			this.save(contactToUpdate);
			return contactToUpdate;
		}
		return null;
	}
}
