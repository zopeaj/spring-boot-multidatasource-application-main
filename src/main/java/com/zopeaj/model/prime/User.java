package com.zopeaj.model.prime;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "user_tb")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;
	private String name;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	@OneToMany(mappedBy="user")
	private Set<Role> roles;
	@OneToOne
	private Contact contact;
	public User() {}
	
	public User(UUID userId, String name, String username, String password, String firstName, String lastName, Contact contact, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.contact = contact;
		this.email = email;
	}
	
	public UUID getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Role role) {
		this.roles.add(role);
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles + ", contact=" + contact
				+ "]";
	}
}
