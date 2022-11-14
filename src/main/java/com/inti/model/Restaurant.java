package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected int num;
	protected String adresse;
	protected int cp;
	protected String ville;
	protected String telephone;	
	
	public Restaurant(int num, String adresse, int cp, String ville, String telephone) {
		super();
		this.num = num;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
	}

	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	protected Entreprise entreprise;
	
	@ManyToMany
	@JoinTable(name = "Produit_Restaurant",
				joinColumns = @JoinColumn(name = "idRestaurant"),
				inverseJoinColumns = @JoinColumn(name = "idProduit"))
	protected List<Produit> listeProduit;

}
