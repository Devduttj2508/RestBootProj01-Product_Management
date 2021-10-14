package com.nit.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dev.entity.Product;
import com.nit.dev.exception.ProductNotFoundException;
import com.nit.dev.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Product registerProduct(Product product) {
		Product prod = null;
		// call repository class method
		prod = repo.save(product);
		return prod;
	}// method

	@Override
	public List<Product> fetchAllProduct() {
		List<Product> listProd = null;
		// call repository class method
		listProd = repo.findAll();
		return listProd;
	}

	@Override
	public Product fetchProductById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Product alterProduct(Product product) {
		Product prod = null;
		Optional<Product> optional = repo.findById(product.getProdId());
		if (optional.isPresent()) {
			prod = optional.get();
			prod.setProdName(product.getProdName());
			prod.setPrice(product.getPrice());
			prod = repo.save(prod);
		}
		return prod;
	}// method

	@Override
	public int removeProduct(int id) {
		Product prod = null;
		Optional<Product> optional = repo.findById(id);
		if (optional.isPresent()) {
			prod = optional.get();
			repo.deleteById(prod.getProdId());
		}
		return prod.getProdId();
	}

	@Override
	public Product fetchProductByName(String name) {
		Product prod = null;
		// call repository method
		prod = repo.findByName(name);
		return prod;
	}
}// class
