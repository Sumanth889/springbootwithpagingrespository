package com.example.springbootwithcrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootwithcrud.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	Optional<Product> findById(Integer prod);

	public List<Product> findAllByManfacturer(String manfacturer);

	public List<Product> findAllByPriceAndManfacturer(String p,Double id);

	public List<Product> findAllByNameAndPrice(String n, String s);
	
}