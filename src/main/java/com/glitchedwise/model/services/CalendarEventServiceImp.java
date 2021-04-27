package com.glitchedwise.model.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.glitchedwise.model.entities.Event;
import com.glitchedwise.model.repositories.CalendarEventExtraRepository;
import com.glitchedwise.model.repositories.CalendarEventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor	
public class CalendarEventServiceImp implements CalendarEventService{

	private CalendarEventRepository calendarEventRepository;
	
	private CalendarEventExtraRepository calendarEventExtraRepository;

	public Event saveCalendarEvent(Event event) {
		if (event == null)
			return null;
		try {
			return calendarEventRepository.save(event);
		} catch (Throwable t) {
			throw t;
		}
	}

	@Override
	public List<Event> findAll() {
		try {
			return StreamSupport.stream(calendarEventRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Throwable t) {
			throw t;
		}
	}

	@Override
	public Event delete(Event event) {
		if (event == null)
			return null;
		try {
			Event deletedEvent = event;
			calendarEventRepository.delete(event);
			return deletedEvent;
		} catch (Throwable t) {
			throw t;
		}
	}

	@Override
	public List<Event> findCalendarEventByFilter(Map<String, Object>  buildFilters) {
		
		try {
			return calendarEventExtraRepository.findCalendarEventByFilter(buildFilters);
			
		} catch (Throwable t) {
			throw t;
		}
	}

}
