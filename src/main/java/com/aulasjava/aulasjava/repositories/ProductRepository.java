package com.aulasjava.aulasjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulasjava.aulasjava.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
