package com.nit.dev.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dev.entity.Product;
import com.nit.dev.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity addProduct(@RequestBody Product product) {
		Product result = null;
		// call service class method
		result = service.registerProduct(product);
		return ResponseEntity.ok(result).status(HttpStatus.CREATED).build();
	}// addProduct()

	@GetMapping(value = "/allProducts", produces = "application/json")
	public ResponseEntity searchAllProducts() {
		List<Product> result = null;
		// call service method
		result = service.fetchAllProduct();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity searchProductById(@PathVariable("id") int id) {
		// call service method
		Product result = service.fetchProductById(id);
		return ResponseEntity.ok(result);
	}

	@PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		Product result = null;
		// call service method
		result = service.alterProduct(product);
		return ResponseEntity.ok("Updated Successfull");
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteProduct(@Validated @PathVariable("id") int id) {
		// call service method
		int result = service.removeProduct(id);
		String msg = "prodcut is deleted successfully of prodId:- " + result;
		return ResponseEntity.ok(msg);
	}

	@GetMapping(value = "/name/{name}", produces = "application/json")
	public ResponseEntity getProductByName(@PathVariable("name") String name) {
		// call service method
		Product prod = service.fetchProductByName(name);
		return ResponseEntity.ok(prod);
	}
}// class
