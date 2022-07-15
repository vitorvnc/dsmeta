package com.devjava.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjava.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	

}
