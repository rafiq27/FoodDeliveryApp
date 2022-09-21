package com.fooddeliveryapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(nullable=false, length=20)
	private String name;
	
	@Column(nullable=false, unique=true, length=40)
	private String email;
	
	@Column(nullable=false, length=20)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
