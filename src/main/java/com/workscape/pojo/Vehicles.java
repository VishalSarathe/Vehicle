package com.workscape.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement
public class Vehicles {
	 private List<Vehicle> vehicle;

	 public Vehicles() {
		// TODO Auto-generated constructor stub
	}
	 
	 @XmlElement 
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	  
}
