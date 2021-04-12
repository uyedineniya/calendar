package com.glitchedwise.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glitchedwise.model.entities.Event;
import com.glitchedwise.model.forms.EventForm;
import com.glitchedwise.model.services.CalendarEventService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class CalendarEventController {

	private CalendarEventService calendarEventService;

	//responsavel por fazer o doFilter() na hora que o usuario logar, trazendo todos os eventos do usuário X
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	public List<Event> lisEvents(EventForm eventForm) {
		
		try {
			
			return calendarEventService.findCalendarEventByFilter(eventForm.buildFilters());

		} catch (Throwable t) {
			throw t;
		}
	}
	
	//responsavel por retornar todo os eventos registrados no banco de dados
	@RequestMapping(value = "/list-all", method = RequestMethod.GET)
	public List<Event> listAllEvents(EventForm eventForm) {

		try {
			return calendarEventService.findAll();

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
