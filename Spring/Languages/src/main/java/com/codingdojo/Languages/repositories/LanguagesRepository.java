package com.codingdojo.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Languages.models.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {
	List<Languages> findAll();
}
