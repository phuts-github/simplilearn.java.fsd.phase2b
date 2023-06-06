package com.simplilearn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	private int id;
	private String Pass;
	private String Name;
	private String Email;
	private String Contact;
	private String Type;
	
	public Users() {}

	public Users(int id, String pass, String name, String email, String contact, String type) {
		super();
		this.id = id;
		Pass = pass;
		Name = name;
		Email = email;
		Contact = contact;
		Type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", Pass=" + Pass + ", Name=" + Name + ", Email=" + Email + ", Contact=" + Contact
				+ ", Type=" + Type + "]";
	}

	


}
