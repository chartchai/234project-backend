package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    ProductServiceImpl productService;
    ProductDao productDao;

    @Before
    public void setup(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetProducts(){
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("D001","Milk","Drink","image/",2500));
        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(), hasItem(new Product("D001","Milk","Drink","image/",2500)));
    }

    @Test(expected = AssertionError.class)
    public void testGetProductsWithException(){
        assertThat(productService.getAllProducts(), nullValue());
    }

}
