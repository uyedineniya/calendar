package com.glitchedwise.model.repositories;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.glitchedwise.model.entities.Event;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CalendarEventExtraRepositoryImp implements CalendarEventExtraRepository {

	private EntityManager entityMananger;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Event> findCalendarEventByFilter(Map<String, Object> filters) {
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(buildQuery(filters).toString());
			if(buildWhere(filters) != null) {
				sb.append(" WHERE");
				sb.append(buildWhere(filters).toString());
			}
			
			Session session = entityMananger.unwrap(Session.class);
			Query query = session.createQuery(sb.toString());
			
			setParameters(query, filters);
			
			return query.getResultList();
			
		}catch(Exception e) {
			throw e;
		}
	}

	private StringBuilder buildQuery(Map<String, Object> filters) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT e FROM Event e ");
		sb.append(" INNER JOIN fetch e.user ");

		return sb;
	}

	private StringBuilder buildWhere(Map<String, Object> filters) {
		StringBuilder sb = new StringBuilder();

		Integer userId = (Integer) filters.get("userId");
		Integer eventId = (Integer) filters.get("eventId");
		Date dateEvent = (Date) filters.get("dateEvent");
		String title = (String) filters.get("title");
		String description = (String) filters.get("description");
		String urgenceLevel = (String) filters.get("urgenceLevel");
		String eventType = (String) filters.get("eventType");
		
		if (userId != null) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.user.id = :userId ");
		}

		if (eventId != null) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.id = :eventId ");
		}

		if (dateEvent != null) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.dateEvent = :dateEvent ");
		}

		if (title != null && !title.trim().isBlank()) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.title = :title ");
		}

		if (description != null && !description.trim().isBlank()) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.description = :description ");
		}

		if (urgenceLevel != null && !urgenceLevel.trim().isBlank()) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.urgenceLevel = :urgenceLevel ");
		}

		if (eventType != null && !eventType.trim().isBlank()) {
			sb.append(sb.length() > 0 ? " AND " : " ");
			sb.append(" e.eventType = :eventType ");
		}

		return sb.length() > 0 ? sb : null;
	}
	
	@SuppressWarnings("rawtypes")
	private void setParameters(Query query, Map<String, Object> filters) {
		
		for(Entry<String, Object> map : filters.entrySet()) {
			query.setParameter(map.getKey(), map.getValue());
		}
	}

}
