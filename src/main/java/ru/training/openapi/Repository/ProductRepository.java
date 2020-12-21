package ru.training.openapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.training.openapi.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}