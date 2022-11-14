package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Produit;
import com.inti.repository.IProduitRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("produit")
@Slf4j
public class ProduitController {
	
	@Autowired
	IProduitRepository produitRepository;
	
	@GetMapping("produits")
	public List<Produit> getProduits()
	{
		return produitRepository.findAll();
	}
	
	@GetMapping("produit/{reference}")
	public Produit getProduit(@PathVariable String reference)
	{
		return produitRepository.findById(reference).get();
	}
	
	@PostMapping("saveProduit")
	public boolean saveProduit(@RequestBody Produit e)
	{
		if(e != null)
		{
			produitRepository.save(e);
			return true;
		}
		
		return false;
	}
	
	@PostMapping("updateProduit")
	public boolean updateProduit(@RequestBody Produit e)
	{
		if(e != null & produitRepository.findAllReferences().contains(e.getReference()))
		{
			produitRepository.save(e);
			return true;
		}
		
		log.error("L'objet produit avec la référence : " + e.getReference() + " n'a pas pu être modifié");
		return false;
	}
	
	@DeleteMapping("deleteProduit/{ref}")
	public boolean deleteProduit(@PathVariable String ref)
	{
		try {
			if(produitRepository.findAllReferences().contains(ref))
			{
				produitRepository.deleteById(ref);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

}
