package com.example.springbootwithcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springbootwithcrud.entity.Product;
import com.example.springbootwithcrud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@CacheEvict(value = "AllProducts",allEntries = true)
	public Product save(Product product)
	{
		return productRepository.save(product);
	}

	@CacheEvict(value = "AllProducts",allEntries = true)
	public List<Product> getproductsbymanfacturer(String manfacturer)
	{
		return productRepository.findAllByManfacturer(manfacturer);
	}

	@CacheEvict(value = "AllProducts",allEntries = true)
	public Optional<Product> getproduct(Integer prod)
	{
		return productRepository.findById(prod);
	}

	@Cacheable(value  = "AllProducts")
	public Iterable<Product> getAllProducts()
	{
		return  productRepository.findAll();
	}

	@CacheEvict(value  = "AllProductss",allEntries = true)
	public Iterable<Product> getAllProductss()
	{
		return  productRepository.findAll();
	}

	@CacheEvict(value = "AllProducts",allEntries = true)
	public List<Product> GetproductsByPriceAndManfacturer(String p,Double id)
	{
		return productRepository.findAllByPriceAndManfacturer(p, id);
	}

	@CacheEvict(value = "AllProducts",allEntries = true)
	public List<Product> GetProductsByNameAndPrice(String n,String s)
	{
		return productRepository.findAllByNameAndPrice(n,s);
	}

	public List<Product> getAllProductsUsingPagination(Integer pageNo ,Integer recordsInEachPage)
	{
		Pageable pageable = PageRequest.of(pageNo,recordsInEachPage);
		Page<Product> page= productRepository.findAll(pageable);
		return page.getContent();

	}

}

