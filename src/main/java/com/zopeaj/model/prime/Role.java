package com.zopeaj.model.prime;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "role_tb")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID roleId;
	private String name;
	@ManyToOne
	private User user;
	
	public Role() {}
	
	public Role(UUID roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", user=" + user + "]";
	}
}
