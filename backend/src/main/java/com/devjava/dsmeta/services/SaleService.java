package com.devjava.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devjava.dsmeta.entities.Sale;
import com.devjava.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = maxDate.equals("") ? today.minusDays(365): LocalDate.parse(maxDate);
		LocalDate max = maxDate.equals("") ? today: LocalDate.parse(maxDate);
		return repository.findSales(min, max, pageable);		
	}

}
