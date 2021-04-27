package com.glitchedwise.model.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.glitchedwise.model.entities.Event;

@Service
public interface CalendarEventService {

	public Event saveCalendarEvent(Event event);

	public List<Event> findAll();

	public Event delete(Event event);

	public List<Event> findCalendarEventByFilter(Map<String, Object> buildFilters);
	
}
