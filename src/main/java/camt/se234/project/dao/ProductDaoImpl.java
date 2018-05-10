package camt.se234.project.dao;

import camt.se234.project.entity.Product;
import camt.se234.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductDaoImpl implements ProductDao{
    List<Product> products;
    public ProductDaoImpl(){
        products.add(new Product(201L,"23","game","description","image",40.56));
        products.add(new Product(202L,"24","titi","description","image",45.56));
        products.add(new Product(203L,"26","pen","description","image",34.75));
        products.add(new Product(204L,"27","fan","description","image",85.89));
        products.add(new Product(205L,"28","bag","description","image",55.60));
    }
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
