package com.devsuperior.dsvendaS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendaS.dto.SaleDTO;
import com.devsuperior.dsvendaS.dto.SaleSuccessDTO;
import com.devsuperior.dsvendaS.dto.SaleSumDTO;
import com.devsuperior.dsvendaS.entities.Sale;
import com.devsuperior.dsvendaS.repositories.SaleRepository;
import com.devsuperior.dsvendaS.repositories.SellerRepository;

@Service
public class SaleService {

	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}
