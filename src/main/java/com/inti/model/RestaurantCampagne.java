package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class RestaurantCampagne extends Restaurant {
	
	private boolean rondPoint;
	private boolean circulation;
	
	public RestaurantCampagne(int num, String adresse, int cp, String ville, String telephone, boolean rondPoint,
			boolean circulation) {
		super(num, adresse, cp, ville, telephone);
		this.rondPoint = rondPoint;
		this.circulation = circulation;
	}
	
	

}
