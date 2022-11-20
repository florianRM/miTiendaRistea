package com.jacaranda.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jacaranda.carrito.ItemCart;

@Entity
public class Users {
	
	@Id
	private String username;
	private String password;
	private String name;
	private String last_name;
	private LocalDate date_birth;
	private char gender;
	private boolean admin;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	List<ItemCart> itemsCart = new ArrayList<>();
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Users(String username, String password, String name, String last_name, LocalDate date_birth,
			char gender, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.last_name = last_name;
		this.date_birth = date_birth;
		this.gender = gender;
		this.admin = admin;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name1() {
		return last_name;
	}

	public void setLast_name1(String last_name1) {
		this.last_name = last_name1;
	}

	public LocalDate getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(LocalDate date_birth) {
		this.date_birth = date_birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(username, other.username);
	}

}