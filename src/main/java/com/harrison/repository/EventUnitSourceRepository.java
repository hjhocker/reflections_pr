package com.harrison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.domain.EventUnitSource;

@Repository
public interface EventUnitSourceRepository extends JpaRepository<EventUnitSource, Long> {

	EventUnitSource findBySourceNameAndSourceId(String sourceName, String sourceId);

}
