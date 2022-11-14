package com.inti.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	
	@Id
	private String reference;
	private int type;
	private LocalDate dateFabrication;
	private LocalDate dateExpiration;

}
