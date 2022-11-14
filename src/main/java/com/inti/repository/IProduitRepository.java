package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Produit;

@Repository
public interface IProduitRepository extends JpaRepository<Produit, String> {
	
	@Query(value = "select reference from produittp1", nativeQuery = true)
	List<String> findAllReferences();

}
