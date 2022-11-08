package com.one.innovation.digital.ifood.repository

import com.one.innovation.digital.ifood.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long>
