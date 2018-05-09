package camt.se234.project.service;

import camt.se234.project.Exceptions.NoDataException;
import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        if (productDao.getProducts().size()==0){
            throw new AssertionError();
        }
        return productDao.getProducts();
    }

    @Override
    public List<Product> getAvailableProducts() {
        List<Product> products = new ArrayList<>();
        for (Product product :
                productDao.getProducts()) {
            if (product.getPrice() > 0){
                products.add(product);
            }
            
        }

        if (products.size()==0){
            throw new NoDataException();
        }
        return products;
    }

    @Override
    public int getUnavailableProductSize() {
        if (getAllProducts().size() - getAvailableProducts().size() ==0){
            throw new NoDataException();
        }

        return getAllProducts().size() - getAvailableProducts().size();
    }
}
