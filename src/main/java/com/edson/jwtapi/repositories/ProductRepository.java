package com.edson.jwtapi.repositories;

import com.edson.jwtapi.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
