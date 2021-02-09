package entities;

import java.util.Date;

public class Contract {
	
	private Date date;
	private Double valueperhour;
	private Integer hours;
		
	
	// constructor
	public Contract(Date date, Double valueperhour, Integer hours) {
		this.date = date;
		this.valueperhour = valueperhour;
		this.hours = hours;
	}
	
	// empty constructor
	public Contract() {
		
	}

	
	// Getters - Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueperhour() {
		return valueperhour;
	}

	public void setValueperhour(Double valueperhour) {
		this.valueperhour = valueperhour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	
	// Total Value of hours
	public double totalValue() {
		return this.hours*valueperhour;
		
	}
	
	
		

}
