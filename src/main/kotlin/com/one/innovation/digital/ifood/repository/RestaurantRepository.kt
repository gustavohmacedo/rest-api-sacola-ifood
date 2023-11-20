package com.one.innovation.digital.ifood.repository

import com.one.innovation.digital.ifood.entity.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long>
