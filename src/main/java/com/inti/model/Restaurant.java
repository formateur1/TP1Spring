package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Restaurant {
	
	@Id
	protected int num;
	protected String adresse;
	protected int cp;
	protected String ville;
	protected String telephone;

}
