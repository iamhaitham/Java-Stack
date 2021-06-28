package com.codingdojo.Events.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	
	@Query(value="SELECT * FROM events WHERE events.location=?1",nativeQuery=true)
	List<Event> findEventByLocation(String location);
	
	@Query(value="SELECT * FROM events WHERE events.location NOT IN (?1)",nativeQuery=true)
	List<Event> findEventByOtherLocations(String location);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM events WHERE events.id=?1",nativeQuery=true)
	void deleteEvent(Long id);
	
	@Query(value="SELECT * FROM events WHERE events.id=?1",nativeQuery=true)
	Event findEventById(Long id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE events SET event_name=?1,location=?2,event_date=?3 WHERE id=?4 ",nativeQuery=true)
	void editEvent(String event_name,String location,Date event_date,Long id);
}
