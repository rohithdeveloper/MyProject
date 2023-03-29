package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tenant")
public class Tenant {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tenantid")
	@NotNull
	private int tenantid;
	@Column(name="tenantage")
	@Min(18)
	@Max(50)
	private int tenantage;
	@Column(name="tenantaddress")
	@NotNull
	private String tenantaddress;
	
	public Tenant() {
		
	}
	
	public Tenant(int tenantid, int tenantage, String tenantaddress) {
		super();
		this.tenantid = tenantid;
		this.tenantage = tenantage;
		this.tenantaddress = tenantaddress;
	}

	public int getTenantid() {
		return tenantid;
	}
	public void setTenantid(int tenantid) {
		this.tenantid = tenantid;
	}
	public int getTenantage() {
		return tenantage;
	}
	public void setTenantage(int tenantage) {
		this.tenantage = tenantage;
	}
	public String getTenantaddress() {
		return tenantaddress;
	}
	public void setTenantaddress(String tenantaddress) {
		this.tenantaddress = tenantaddress;
	}

}
