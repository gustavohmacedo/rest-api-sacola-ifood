package com.one.innovation.digital.ifood.repositories

import com.one.innovation.digital.ifood.entities.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long>
