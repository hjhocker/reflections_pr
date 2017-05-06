package com.harrison.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harrison.domain.EventComponent;

@Repository
public interface EventComponentRepository extends JpaRepository<EventComponent, Long> {

	List<EventComponent> findAll();
	
	EventComponent findById(long id);
	
	List<EventComponent> findByEventId(String id);
	
	@Query(nativeQuery = true, value = "select nextval('event_id_sequence')")
	long getSequenceValue();

}
