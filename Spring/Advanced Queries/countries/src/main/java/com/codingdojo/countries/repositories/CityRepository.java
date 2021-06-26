package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.City;
import com.codingdojo.countries.models.Language;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();
	
	// QUESTION 7
	@Query("SELECT cc.name,c.name,c.district,c.population FROM City c JOIN c.country cc WHERE cc.name='Argentina' AND c.district='Buenos Aires' AND c.population>1000")
	List<Object[]> findSpecificCitiesInArgentinaBuenosAires();
}
