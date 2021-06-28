package com.codingdojo.Events.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Events.models.Event;
import com.codingdojo.Events.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;
	public EventService(EventRepository eventRepository) {
		this.eventRepository=eventRepository;
	}
	public List<Event> findEventsByLocation(String location){
		return eventRepository.findEventByLocation(location);
	}
	
	public List<Event> findEventsByOtherLocations(String location) {
		return eventRepository.findEventByOtherLocations(location);
	}
	
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public Event updateEvent(Event myEvent) {
		return eventRepository.save(myEvent);
	}
	
	public void deleteEvent(Long id) {
		eventRepository.deleteEvent(id);
	}
	
	public Event findEventById(Long id) {
		return eventRepository.findEventById(id);
	}
	
	public void editEvent(String event_name,String location,Date event_date,Long id) {
		eventRepository.editEvent(event_name,location,event_date,id);
	}
}
