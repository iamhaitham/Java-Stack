package com.codingdojo.Roster1.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Roster1.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO users (age,first_name,last_name) VALUES (:age,:firstName,:lastName)",nativeQuery=true)
	void createUser(int age,String firstName,String lastName);
	
	@Modifying
	@Transactional
	@Query(value="SELECT users.id AS ID,CONCAT(first_name,last_name) AS Name, CONCAT(address,city,state) AS Address ,contacts.id AS Contact_id FROM users INNER JOIN contacts ON users.id=contacts.user_id",nativeQuery=true)
	List<Object[]> displayInfo();
}
