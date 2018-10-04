package com.yodlee.engg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="YODLEE_EVENT")
public class Yodlee_Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Event_Id")
	private int eventId;
	@Column(name="Event_Name",nullable=false, length=100)
	private String name;
	@Column(name="Event_Date",nullable=false)
	@Temporal(value = TemporalType.DATE)
	private Date eventDate;
	@Column(name="Event_Location", length=100)
	private String location;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}
