package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Entreprise {
	
	@Id
	private int id;
	private String nom;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
	List<Restaurant> listeRestaurant;

}
