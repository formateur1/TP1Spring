package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.repository.IEntrepriseRepository;

@RestController
@RequestMapping("entreprise")
public class EntrepriseController {
	
	@Autowired
	IEntrepriseRepository entrepriseRepository;

}
