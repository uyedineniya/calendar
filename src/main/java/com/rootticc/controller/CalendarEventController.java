package com.rootticc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rootticc.model.services.CalendarEventService;
import com.rootticc.model.entities.Event;
import com.rootticc.model.forms.EventForm;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class CalendarEventController {

	private CalendarEventService calendarEventService;

	//responsavel por realizar a busca geral
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	public List<Event> lisEvents(EventForm eventForm) {
		
		try {
			
			return calendarEventService.findCalendarEventByFilter(eventForm.buildFilters());

		} catch (Throwable t) {
			throw t;
		}
	}

	//responsavel por salvar e dar update nos dados
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Event saveEvent(EventForm eventForm) {

		if (eventForm == null)
			return null;

		try {
			return calendarEventService.saveCalendarEvent(eventForm.formToEntity());

		} catch (Throwable t) {
			throw t;
		}
	}
	
	//responsavel por remover os eventos unicos, logo depoisd de algumas mudanças será capaz de remover os selecionados pelo usuario
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Event deleteEvent(EventForm eventForm) {

		if (eventForm == null)
			return null;

		try {
			return calendarEventService.delete(eventForm.formToEntity());

		} catch (Throwable t) {
			throw t;
		}
	}
}
