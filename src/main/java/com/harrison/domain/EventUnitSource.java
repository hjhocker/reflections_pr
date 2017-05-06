package com.harrison.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event_unit_sources")
public class EventUnitSource implements Serializable {

	private static final long serialVersionUID = 3225553595128126839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "source_name")
	private String sourceName;
	
	@Column(name = "source_id")
	private String sourceId;

	@JsonIgnore
	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "event_component_id", unique = true, nullable = false)
	public EventComponent event;

	public EventUnitSource() {
		//default constructor
	}
	
	public EventUnitSource(long id, String sourceName, String sourceId, EventComponent event) {
		this.id = id;
		this.sourceName = sourceName;
		this.sourceId = sourceId;
		this.event = event;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public EventComponent getEvent() {
		return event;
	}

	public void setEvent(EventComponent event) {
		this.event = event;
	}
	
	
}
