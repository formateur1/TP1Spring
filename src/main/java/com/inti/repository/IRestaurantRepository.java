package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.model.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	@Query(value = "select max(num) from restaurant_campagne", nativeQuery = true)
	int findMaxNumCampagne();
	
	@Query(value = "select max(num) from restaurant_ville", nativeQuery = true)
	int findMaxNumVille();

}
