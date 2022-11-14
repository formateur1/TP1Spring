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

import com.inti.model.Restaurant;
import com.inti.model.RestaurantCampagne;
import com.inti.model.RestaurantVille;
import com.inti.repository.IRestaurantRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("restaurant")
@Slf4j
public class RestaurantController {
	
	@Autowired
	IRestaurantRepository restaurantRepository;
	
	@GetMapping("restaurants")
	public List<Restaurant> getRestaurants()
	{
		return restaurantRepository.findAll();
	}
	
	@GetMapping("restaurant/{id}")
	public Restaurant getRestaurant(@PathVariable int id)
	{
		return restaurantRepository.findById(id).get();
	}
	
	@PostMapping("saveRestaurantVille")
	public boolean saveRestaurant(@RequestBody RestaurantVille e)
	{
		if(e != null)
		{
			restaurantRepository.save(e);			
			return true;
		}
		
		return false;
	}
	
	@PostMapping("saveRestaurantCampagne")
	public boolean saveRestaurant(@RequestBody RestaurantCampagne e)
	{
		if(e != null)
		{
			restaurantRepository.save(e);			
			return true;
		}
		
		return false;
	}
	
	@PostMapping("updateRestaurantVille")
	public boolean updateRestaurantVille(@RequestBody RestaurantVille e)
	{
		if(e != null & e.getNum() > 0 & e.getNum() <= restaurantRepository.findMaxNumVille())
		{
			restaurantRepository.save(e);
			return true;
		}
		
		log.error("L'objet restaurant avec l'id : " + e.getNum() + " n'a pas pu être modifié");
		return false;
	}
	
	@PostMapping("updateRestaurantCampagne")
	public boolean updateRestaurantCampagne(@RequestBody RestaurantCampagne e)
	{
		if(e != null & e.getNum() > 0 & e.getNum() <= restaurantRepository.findMaxNumCampagne())
		{
			restaurantRepository.save(e);
			return true;
		}
		
		log.error("L'objet restaurant avec l'id : " + e.getNum() + " n'a pas pu être modifié");
		return false;
	}
	
	@DeleteMapping("deleteRestaurant/{id}")
	public boolean deleteRestaurant(@PathVariable int id)
	{
		try {
			if(id > 0)
			{
				restaurantRepository.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

}
