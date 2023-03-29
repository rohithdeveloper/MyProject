package com.example.demo.services;

import java.util.List;


import com.example.demo.Exception.NoSuchTenantExceptions;
import com.example.demo.entities.Tenant;


public interface AdminService {

	Tenant addTenant(Tenant tenant);

	String update(Tenant tenant);

	Tenant deleteTenantById(int tenantid);

	List<Tenant> viewAllTenants();

	List<Tenant> findTenantById(int tenantid) throws NoSuchTenantExceptions;



	

}
