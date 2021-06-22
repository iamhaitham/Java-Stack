package com.codingdojo.Relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Relationships.models.License;
@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();

	License findTopByOrderByNumberDesc();
}
