package com.nicolas.licencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.licencia.models.License;
import com.nicolas.licencia.models.Person;
import com.nicolas.licencia.repositories.LicenciaRepo;
import com.nicolas.licencia.repositories.PersonaRepo;

@Service
public class MainService {

	@Autowired
	private PersonaRepo serv;
	@Autowired
	private LicenciaRepo servL;
	//CRUD PERSONAS
	//lista todas las personas
	public List<Person> showAll(){
		return serv.findAll();
	}
	
	//muestra una sola persona por id
	public Person showPersonById(Long id) {
		return serv.findById(id).orElse(null);
	}
	
	//crear persona
	public void createPerson(Person p) {
		serv.save(p);
	}
	public List<Person> findByNoLicense(){
		return serv.findByLicenseIdIsNull();
	}
	
	//CRUD LICENCIAS
	public License createLicense(License l) {
		return servL.save(l);
	}
	
	/*public int generarNumeroLic() {
		License lic = servL.
	}*/
	
	
	
}
