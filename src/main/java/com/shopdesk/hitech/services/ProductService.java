package com.shopdesk.hitech.services;

import com.shopdesk.hitech.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);
    Page<List<Product>> findByName(String name);

    Page<Product> findAllProductPageable(Pageable pageable);

}
