package com.example.demo.repositories;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Tenant;

@Repository
public interface TenantRepository extends CrudRepository<Tenant,Integer>{

	public List<Tenant> findTenantById(@Param("tenantid") int tenantid);


}
