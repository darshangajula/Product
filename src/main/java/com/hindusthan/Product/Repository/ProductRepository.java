package com.hindusthan.Product.Repository;

import com.hindusthan.Product.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
