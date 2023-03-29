package com.example.demo.services.serviceimplementation;



import java.util.List;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.NoSuchTenantExceptions;
import com.example.demo.entities.Tenant;
import com.example.demo.repositories.TenantRepository;
import com.example.demo.services.AdminService;

@Service
@Component
	public  class TenantServices implements AdminService {
		@Autowired
		TenantRepository tenantRepository;
		public int ResponseEntity;
		
		@Override
		public Tenant addTenant(Tenant tenant) {
			// TODO Auto-generated method stub
			return tenantRepository.save(tenant);
		}
		@Override
		public List<Tenant> viewAllTenants() {
			// TODO Auto-generated method stub
			return (List<Tenant>) tenantRepository.findAll();
		}

		@Override
		public String update(Tenant tenant) {
			// TODO Auto-generated method stub
			//return tenantRepository.save(tenant);
			String message="tenant updated successfully";
			Tenant t=tenantRepository.save(tenant);
			if(t==null)
			{
				return "tenant not updated";
			}
			else
			{
				return message;
			}
		}

		@Override
		public Tenant deleteTenantById(int tenantid) {
			// TODO Auto-generated method stub
			Tenant result=deleteTenantById(tenantid);
			tenantRepository.delete(result);
			return result;
		}

		

//		public Optional<Tenant> findTenantById(int tenantid) {
//			// TODO Auto-generated method stub
//			return tenantRepository.findById(tenantid);
//		}
//
//		public Optional<Tenant> viewTenantById(int tenantid) {
//			// TODO Auto-generated method stub
//			return tenantRepository.findById(tenantid);
//		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Tenant> findTenantById(int tenantid) throws NoSuchTenantExceptions {
			// TODO Auto-generated method stub
//			return tenantRepository.findById(tenantid);
			try {
				List<Tenant> tenant =(List<Tenant>) tenantRepository.findById(tenantid).get();
				if(tenant!=null)
				{
					return tenant;
				}
			}catch(NoSuchElementException e){
					throw new NoSuchTenantExceptions("tenant with"+tenantid+" not found");
				}
				return null;
				}
		}

		

		
		
		
		
		

