package com.example.springbootwithcrud.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootwithcrud.entity.Product;
import com.example.springbootwithcrud.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;
	Logger log = LoggerFactory.getLogger(ProductController.class);
	@PostMapping("save")
	public Product save(@RequestBody Product product)
	{
		return  productService.save(product);
	}

	@GetMapping("manfacturer")
    public List<Product> getProductsByManfacturer(@PathVariable String manfacturer)
    {
    	return productService.getproductsbymanfacturer(manfacturer);
    }
	
	@GetMapping("product")
	public Optional<Product> getproduct(@PathVariable Integer prod)
	{
		return productService.getproduct(prod);
	}
	
	@RequestMapping(value = "products" , method = RequestMethod.GET)
	public Iterable<Product> getAllProducts()
	{
		Iterable<Product> prd=	 productService.getAllProducts();
		log.info("Product List:{}",prd);
		 return prd;
	}
	
	@GetMapping("AllProductss")
	public Iterable<Product> getAllProductss()
	{
		return  productService.getAllProductss();
	}
	
	@GetMapping("prices")
	public List<Product> GetproductsByPriceAndManfacturer(@RequestParam String p,@PathVariable Double id)
	{
		return productService.GetproductsByPriceAndManfacturer(p,id);
	}
	
    @GetMapping("names")
	public List<Product> GetProductsByNameAndPrice(@RequestParam("n") String n,@RequestParam String s)
	{
		return productService.GetProductsByNameAndPrice(n, s);
	}
    
    @GetMapping("fetch/{pageNo}/{recordsInEachPage}")
	public List<Product> getAllProductsUsingPagination(@PathVariable Integer pageNo ,@PathVariable Integer recordsInEachPage)
	{
		return productService.getAllProductsUsingPagination(pageNo, recordsInEachPage);

	}
}
