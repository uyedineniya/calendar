package com.glitchedwise.model.forms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.glitchedwise.model.entities.Event;
import com.glitchedwise.model.entities.User;

public class EventForm {

	private Integer userId;
	private Integer eventId;
	private Date dateEvent;
	private String title;
	private String description;
	private String urgenceLevel;
	private String eventType;

	public Map<String, Object>  buildFilters() {
		Map<String, Object>  filters = new HashMap<>();

		if (userId != null) {
			filters.put("userId", userId);
		}

		if (eventId != null) {
			filters.put("eventId", eventId);
		}

		if (dateEvent != null) {
			filters.put("dateEvent", dateEvent);
		}

		if (title != null && !title.trim().isBlank()) {
			filters.put("title", title);
		}

		if (description != null &&  !description.trim().isBlank()) {
			filters.put("description", description);
		}

		if (urgenceLevel != null && !urgenceLevel.trim().isBlank()) {
			filters.put("urgenceLevel", urgenceLevel);
		}

		if (eventType != null && !eventType.trim().isBlank()) {
			filters.put("eventType", eventType);
		}

		return filters;
	}
	
	public Event formToEntity() {
			Event event = new Event();
			User user = new User();
			user.setId(userId);
			event.setUser(user);
			event.setId(eventId);
			event.setDateEvent(dateEvent);
			event.setDescription(description);
			event.setEventType(eventType);
			event.setTitle(title);
			event.setUrgenceLevel(urgenceLevel);
			
			return event;
	}
	
	public EventForm EntityToForm(Event event) {
		
		if(event != null) {
			EventForm eventForm = new EventForm();
			eventForm.setEventId(event.getId());
			eventForm.setUserId(event.getUser().getId());
			eventForm.setDateEvent(event.getDateEvent());
			eventForm.setDescription(event.getDescription());
			eventForm.setEventType(event.getEventType());
			eventForm.setTitle(event.getTitle());
			eventForm.setUrgenceLevel(event.getUrgenceLevel());
			
			return eventForm;
		}

		return null;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgenceLevel() {
		return urgenceLevel;
	}

	public void setUrgenceLevel(String urgenceLevel) {
		this.urgenceLevel = urgenceLevel;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
