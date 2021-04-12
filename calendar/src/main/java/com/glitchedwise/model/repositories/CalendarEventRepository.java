package com.glitchedwise.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glitchedwise.model.entities.Event;

@Repository	
public interface CalendarEventRepository extends CrudRepository <Event, Integer> {

}
