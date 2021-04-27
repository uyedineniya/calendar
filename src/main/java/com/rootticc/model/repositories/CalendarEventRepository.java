package com.rootticc.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rootticc.model.entities.Event;

@Repository	
public interface CalendarEventRepository extends CrudRepository <Event, Integer> {

}
