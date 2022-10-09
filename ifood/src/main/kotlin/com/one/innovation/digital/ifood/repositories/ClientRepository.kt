package com.one.innovation.digital.ifood.repositories

import com.one.innovation.digital.ifood.entities.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long>
