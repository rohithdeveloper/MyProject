package com.example.demo.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="adminId")
	@NonNull
	private int adminId;
	@Column(name="adminPass")
	@NotNull
	private String adminPass;
	
	public Admin() {
		
	}
	public Admin(int adminId, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	
	
	
}
