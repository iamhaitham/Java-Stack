package com.codingdojo.Roster1.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Roster1.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO contacts (user_id,address,city,state) VALUES (:student,:address,:city,:state)",nativeQuery=true)
	void createContact(Long student,String address,String city,String state);
}
