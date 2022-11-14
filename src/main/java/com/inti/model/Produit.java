package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProduitTP1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	
	@Id
	private String reference;
	private int type;
	private LocalDate dateFabrication;
	private LocalDate dateExpiration;
	
	@ManyToMany
	@JoinTable(name = "Produit_Restaurant",
				joinColumns = @JoinColumn(name = "idProduit"),
				inverseJoinColumns = @JoinColumn(name = "idRestaurant"))
	List<Restaurant> listeRestaurant;

}
