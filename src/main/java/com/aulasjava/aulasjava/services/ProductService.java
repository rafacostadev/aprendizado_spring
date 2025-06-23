package com.aulasjava.aulasjava.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aulasjava.aulasjava.DTO.ProductDTO;
import com.aulasjava.aulasjava.entities.Product;
import com.aulasjava.aulasjava.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> result = productRepository.findById(id);
		return modelMapper.map(result.get(), ProductDTO.class);
	}

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		return productRepository.findAll(pageable).map(x -> modelMapper.map(x, ProductDTO.class));
	}

	public ProductDTO insert(ProductDTO dto) {
		return modelMapper.map(productRepository.save(modelMapper.map(dto, Product.class)), ProductDTO.class);
	}
}
