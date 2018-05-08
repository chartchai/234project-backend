package camt.se234.project;


import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.service.ProductServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProductServiceImplTests {
    ProductServiceImpl productService;
    ProductDao productDao;

    @Before
    public void setup() {
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }


    @Test
    public void testGetAllProducts(){

        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",50.0));
        mockProducts.add(new Product("000003L","p3","product3","p3.jpg",100.0));

        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(),hasItems(
                new Product("000001L","p1","product1","p1.jpg",100.0),
                new Product("000002L","p2","product2","p2.jpg",50.0)
        ));



    }

    @Test
    public void testGetAvailableProducts(){

        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",150.0));


        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(),hasItems(
                new Product("000001L","p1","product1","p1.jpg",100.0),
                new Product("000002L","p2","product2","p2.jpg",150.0)
        ));



    }

    @Test
    public void testGetUnavailableProductSize(){
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",-50.0));

        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getUnavailableProductSize(),is(1));
    }
}
