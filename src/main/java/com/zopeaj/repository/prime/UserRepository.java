package com.zopeaj.repository.prime;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zopeaj.model.prime.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;

@Repository
@Transactional
public class UserRepository {
	
	@PersistenceContext(name="primedbContext")
	private EntityManager entityManager;
	
	public void save(User user) {
		entityManager.persist(user);
	}
	
	public void delete(UUID userId) {
		User userDataToDelete = entityManager.find(User.class, userId);
		if(userDataToDelete != null) {
			entityManager.remove(userDataToDelete);
		}
	}
	
	public User findById(UUID userId) {
		User userData = entityManager.find(User.class, userId);
		if (userData != null) {
			return userData;
		}
		return null;
	}
	
	public List<User> findAllUser() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> userRoot = cq.from(User.class);
		cq.orderBy(cb.desc(userRoot.get("name")));
		List<User> users = entityManager.createQuery(cq).getResultList();
		return users;
	}
	
	public User findUserEmail(String email) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> userRoot = cq.from(User.class);
		cq.select(userRoot).where(cb.equal(userRoot.get("email"), email));
		TypedQuery<User> tq = entityManager.createQuery(cq);
		User user = tq.getSingleResult();
		return user;
	}
	
	public User findUserId(UUID userId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> userRoot = cq.from(User.class);
		cq.select(userRoot).where(cb.equal(userRoot.get("userId"), userId));
		TypedQuery<User> tq = entityManager.createQuery(cq);
		User user = tq.getSingleResult();
		return user;
	}
	
	public User updateUser(UUID userId, User user) {
		User userToUpdate = entityManager.find(User.class, userId);
		if(userToUpdate == null) {
			return null;
		}
		userToUpdate.setName(user.getName());
		this.save(userToUpdate);
		return userToUpdate;
	}
	
	
	public void deleteUserById(UUID userId) {
		User user = entityManager.find(User.class, userId);
		if (user != null) {
			entityManager.remove(user);
		}
	}
}
