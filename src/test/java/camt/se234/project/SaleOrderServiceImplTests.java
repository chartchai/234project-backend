package camt.se234.project;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.hibernate.criterion.Order;
import org.junit.Test;
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
public class SaleOrderServiceImplTests {
    SaleOrderServiceImpl saleOrderService;
    OrderDao orderDao;
    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }
    @Test
    public void testGetSaleOrders(){
        List<Order> mockOrders = new ArrayList<>();
        
    }

    @Test
    public void testGetAverageSaleOrderPrice(){

    }
}
