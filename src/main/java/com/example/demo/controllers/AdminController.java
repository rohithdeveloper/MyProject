package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.NoSuchTenantExceptions;
import com.example.demo.entities.Tenant;
import com.example.demo.services.serviceimplementation.TenantServices;




@RestController

@RequestMapping("/api")

public class AdminController {

	
	@Autowired
	TenantServices tenantServices;
	
// Add tenants
	
	@PostMapping("/add-tenants")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant)
	{
		Tenant result=tenantServices.addTenant(tenant);
		if(result!=null) {
			return new ResponseEntity<Tenant>(result,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Tenant>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	
//  view all tenants
	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> viewAllTenants(){
		List<Tenant> result=tenantServices.viewAllTenants();
		if(result!=null)
		{
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
//  update tenants
	
	@PutMapping("/update-tenants")  
	public ResponseEntity<Tenant> update(@RequestBody Tenant tenant)   	
	{  
		String result=tenantServices.update(tenant);
		if(result!=null) {
			return new ResponseEntity<Tenant>(HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Tenant>(HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

// Delete tenants
	
	@DeleteMapping("/tenants/{tenantid}")
	public ResponseEntity<?> deleteTenantById(@PathVariable int tenantid) throws NoSuchTenantExceptions  {
		Tenant result = tenantServices.deleteTenantById(tenantid);
		if(result!=null)
			return new ResponseEntity<>("tenant deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

// view tenant by id
	
	@GetMapping("/tenants/{tenantid}")
	private ResponseEntity<?> viewTenantById(@PathVariable("tenantid") int tenantid) throws NoSuchTenantExceptions  {
		List<Tenant> result=tenantServices.findTenantById(tenantid);
		if(result!=null)
		{
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		else	
		{
			return new ResponseEntity<>("No tenant available",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
