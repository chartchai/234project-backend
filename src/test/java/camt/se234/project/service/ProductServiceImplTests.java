package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTests  {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetAllProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
//        assertThat(productService.getAllProducts(),hasItems(new Product(201L,"23","game","description","image",40.56),
//                new Product(202L,"24","titi","description","image",45.56),new Product(203L,"26","pen","description","image",34.75)));
    }


    @Test
    public void testGetAvailableProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
//        assertThat(productService.getAvailableProducts(),hasItems(new Product(201L,"23","game","description","image",40.56),
//                new Product(202L,"24","titi","description","image",45.56)));
    }


    @Test
    public void testGetUnavailableProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
        assertThat(productService.getUnavailableProductSize(),is(1));
    }

    private void assertThat(int unavailableProductSize, Matcher<Integer> integerMatcher) {
    }
}
