package camt.se234.project;

<<<<<<< HEAD
import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.service.ProductServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void setup(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
=======
import org.junit.Before;
import org.junit.Test;

public class ProductServiceImplTests {
    @Before
    public void setup(){

>>>>>>> master
    }

    @Test
    public void testGetAllProducts(){
<<<<<<< HEAD
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",50.0));
        mockProducts.add(new Product("000003L","p3","product3","p3.jpg",100.0));

        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(),hasItems(
                new Product("000001L","p1","product1","p1.jpg",100.0),
                new Product("000002L","p2","product2","p2.jpg",50.0)
        ));
=======

>>>>>>> master
    }

    @Test
    public void testGetAvailableProducts(){
<<<<<<< HEAD
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",150.0));


        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts(),hasItems(
                new Product("000001L","p1","product1","p1.jpg",100.0),
                new Product("000002L","p2","product2","p2.jpg",150.0)
        ));
=======

>>>>>>> master
    }

    @Test
    public void testGetUnavailableProductSize(){
<<<<<<< HEAD
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product("000001L","p1","product1","p1.jpg",100.0));
        mockProducts.add(new Product("000002L","p2","product2","p2.jpg",-50.0));

        when(productDao.getProducts()).thenReturn(mockProducts);
        assertThat(productService.getUnavailableProductSize(),is(1));
=======

    }

    @Test
    public void testGetSaleOrders(){

    }

    @Test
    public void testGetAverageSaleOrderPrice(){

>>>>>>> master
    }
}
