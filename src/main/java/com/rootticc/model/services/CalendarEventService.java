package com.rootticc.model.services;

import java.util.List;
import java.util.Map;

import com.rootticc.model.entities.Event;

public interface CalendarEventService {

	public Event saveCalendarEvent(Event event);

	public List<Event> findAll();

	public Event delete(Event event);

	public List<Event> findCalendarEventByFilter(Map<String, Object> buildFilters);
	
}
