package com.aamir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airlineId")
	@SequenceGenerator(name = "airlineId", sequenceName = "airline_id_seq", allocationSize = 1)

	private int airlineId;
	private String airlineName;
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airline(int airlineId, String airlineName) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + "]";
	}
	
}
