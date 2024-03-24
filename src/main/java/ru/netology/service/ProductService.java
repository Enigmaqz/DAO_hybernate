package ru.netology.service;
import org.springframework.stereotype.Service;
import ru.netology.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<String> getProducts(String name) {
        return repository.getProductName(name);
    }
}