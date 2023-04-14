package com.aamir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Airport")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportId")
	@SequenceGenerator(name = "airportId", sequenceName = "airport_id_seq", allocationSize = 1)

	private int airportId;
	private String airportCode;
	private String airportName;
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Airport(int airportId, String airportCode, String airportName) {
		super();
		this.airportId = airportId;
		this.airportCode = airportCode;
		this.airportName = airportName;
	}
	
	public int getAirportId() {
		return airportId;
	}
	
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	
	public String getAirportCode() {
		return airportCode;
	}
	
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	public String getAirportName() {
		return airportName;
	}
	
	public void setAirportName(String airportName) {
		
		this.airportName = airportName;
	}
	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportCode=" + airportCode + ", airportName=" + airportName
				+ "]";
	}
	
}