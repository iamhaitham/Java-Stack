package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	
	// QUESTION 4
	@Query("SELECT cc.name,l.language FROM Language l JOIN l.country cc WHERE l.percentage>89 ORDER BY l.percentage DESC")
	List<Object[]> findLanguagesInEachCountry();
}
