package camt.se234.project.dao;

import camt.se234.project.entity.Product;

import java.util.List;

public interface ProductDao{
    List<Product> getProducts();
    List<Product> findAll();
}
