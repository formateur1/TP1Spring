package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class RestaurantVille extends Restaurant {
	
	private double taxeSup;

	public RestaurantVille(int num, String adresse, int cp, String ville, String telephone, double taxeSup) {
		super(num, adresse, cp, ville, telephone);
		this.taxeSup = taxeSup;
	}
	
	

}
