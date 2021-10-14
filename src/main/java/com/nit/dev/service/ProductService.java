package com.nit.dev.service;

import java.util.List;

import com.nit.dev.entity.Product;

public interface ProductService {

	public Product registerProduct(Product product);

	public List<Product> fetchAllProduct();

	public Product fetchProductById(int id);

	public Product alterProduct(Product product);

	public int removeProduct(int id);

	public Product fetchProductByName(String name);
}
