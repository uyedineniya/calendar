package com.glitchedwise.model.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.glitchedwise.model.entities.Event;

@Repository
public interface CalendarEventExtraRepository {
	
	
	List<Event> findCalendarEventByFilter(Map<String, Object>  filters);

}
