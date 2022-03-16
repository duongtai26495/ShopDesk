package com.shopdesk.hitech.services.Impl;

import com.shopdesk.hitech.entities.Product;
import com.shopdesk.hitech.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<List<Product>> findByName(String name) {
        return null;
    }

    @Override
    public Page<Product> findAllProductPageable(Pageable pageable) {
        return null;
    }
}
