package com.nicolas.licencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.licencia.models.Person;

@Repository
public interface PersonaRepo extends CrudRepository<Person,Long> {
	
	//metodo q retorna todas las persona de la base de datos
	List<Person> findAll();
	
	//metodo que utiliza una query para buscar a las personas sin licencias
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL",nativeQuery=true)
	List<Person> findByNoLicense();
	
	//metodo JPA para buscar personas sin licencia asociada
	List<Person> findByLicenseIdIsNull();
	
}
