package ru.training.openapi.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.training.openapi.Entity.Product;
import ru.training.openapi.Service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
	    private final ProductService productService;

	    @Autowired
	    public ProductApi(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping
	    public ResponseEntity<List<Product>> findAll() {
	        return ResponseEntity.ok(productService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> findById(@PathVariable Long id) {
	        Optional<Product> product = productService.findById(id);

	        return ResponseEntity.ok(productService.findById(id).get());
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Product> create(@RequestBody Product product) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
	        return ResponseEntity.accepted().body(productService.save(product));
	    }

	    @DeleteMapping("delete/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        productService.deleteById(id);

	        return ResponseEntity.accepted().build();
	    }
	}