package com.nicolas.licencia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicolas.licencia.models.License;

public interface LicenciaRepo extends CrudRepository<License,Long> {
	
	List<License> findAll();
	
	public License findTopByOrderByNumberDesc();
}
