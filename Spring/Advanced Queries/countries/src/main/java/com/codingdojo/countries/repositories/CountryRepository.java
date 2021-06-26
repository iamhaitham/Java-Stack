package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findAll();

	// QUESTION 1
	@Query("SELECT cc.name,l.language,l.percentage FROM Country cc JOIN cc.languages l WHERE language LIKE ?1 ORDER BY l.percentage DESC")
	List<Object[]> findCountryByLang(String language); 
	
	// QUESTION 2
	@Query("SELECT cc.name, COUNT(c.name) FROM Country cc JOIN cc.cities c GROUP BY cc.name ORDER BY COUNT(c.name) DESC")
	List<Object[]> findCitiesCount();

	// QUESTION 3
	@Query("SELECT cc.name,c.name FROM Country cc JOIN cc.cities c WHERE cc.name LIKE ?1")
	List<Object[]> findCitiesByCountryName(String name);
	
	// QUESTION 5
	@Query("SELECT cc.name,cc.surface_area,cc.population FROM Country cc WHERE cc.surface_area<?1 AND cc.population>?2")
	List<Object[]> findCountryByAreaAndPopulation(double surface_area, int population);

	// QUESTION 6
	@Query("SELECT cc.name,cc.government_form,cc.surface_area,cc.life_expectancy FROM Country cc WHERE cc.government_form LIKE 'Constitutional Monarchy' AND cc.surface_area>200 AND cc.life_expectancy>75")
	List<Object[]> findCountryByGovernmentalAndAreaAndLife();
	
	// QUESTION 8
	@Query("SELECT cc.region,COUNT(cc.name) AS myCounter FROM Country cc GROUP BY cc.region ORDER BY myCounter DESC")
	List<Object[]> summarizeCountriesAndRegions();
	
}
