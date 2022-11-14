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

import com.inti.model.Entreprise;
import com.inti.repository.IEntrepriseRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("entreprise")
@Slf4j
public class EntrepriseController {
	
	@Autowired
	IEntrepriseRepository entrepriseRepository;
	
	@GetMapping("entreprises")
	public List<Entreprise> getEntreprises()
	{
		return entrepriseRepository.findAll();
	}
	
	@GetMapping("entreprise/{id}")
	public Entreprise getEntreprise(@PathVariable int id)
	{
		return entrepriseRepository.findById(id).get();
	}
	
	@PostMapping("saveEntreprise")
	public boolean saveEntreprise(@RequestBody Entreprise e)
	{
		if(e != null)
		{
			entrepriseRepository.save(e);
			return true;
		}
		
		return false;
	}
	
	@PostMapping("updateEntreprise")
	public boolean updateEntreprise(@RequestBody Entreprise e)
	{
		if(e != null & e.getId() > 0 & e.getId() <= entrepriseRepository.findMaxId())
		{
			entrepriseRepository.save(e);
			return true;
		}
		
		log.error("L'objet entreprise avec l'id : " + e.getId() + " n'a pas pu être modifié");
		return false;
	}
	
	@DeleteMapping("deleteEntreprise/{id}")
	public boolean deleteEntreprise(@PathVariable int id)
	{
		try {
			if(id > 0 & id <= entrepriseRepository.findMaxId())
			{
				entrepriseRepository.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

}
