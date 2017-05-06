package com.harrison.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "event_components")
public class EventComponent implements Serializable {

	private static final long serialVersionUID = -1236516142120043487L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "is_planning")
	private boolean isPlanning;
	
	@NotNull
	@Column(name = "event_id")
	private String eventId;
	
	@Column(name = "esn")
	private String esn;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "event", optional = false, cascade = CascadeType.ALL)
	private EventUnitSource eventUnitSource;

	public EventComponent() {
		//default constructor
	}

	public EventComponent(long id, boolean isPlanning, String eventId, String esn, EventUnitSource eventUnitSource) {
		this.id = id;
		this.isPlanning = isPlanning;
		this.eventId = eventId;
		this.esn = esn;
		this.eventUnitSource = eventUnitSource;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPlanning() {
		return isPlanning;
	}

	public void setPlanning(boolean isPlanning) {
		this.isPlanning = isPlanning;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEsn() {
		return esn;
	}

	public void setEsn(String esn) {
		this.esn = esn;
	}

	public EventUnitSource getEventUnitSource() {
		return eventUnitSource;
	}

	public void setEventUnitSource(EventUnitSource eventUnitSource) {
		this.eventUnitSource = eventUnitSource;
	}
	
}
