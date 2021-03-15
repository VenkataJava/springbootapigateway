package com.oauth.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Integer id;
	private String username, passworkd;

	public Account(String username, String passworkd) {
		this.username = username;
		this.passworkd = passworkd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassworkd() {
		return passworkd;
	}

	public void setPassworkd(String passworkd) {
		this.passworkd = passworkd;
	}

	public Account() {
	}

}
