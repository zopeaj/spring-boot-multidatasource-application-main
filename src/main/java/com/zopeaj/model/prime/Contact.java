package com.zopeaj.model.prime;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
	@Id 
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id; 
	private String address;
	@OneToOne(mappedBy="contact")
	private User user;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UUID getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Contact { "
					+ "id : " + id + ", "
					+ "address : " + address + 
				"}";
	}
	
}
