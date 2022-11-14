package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
