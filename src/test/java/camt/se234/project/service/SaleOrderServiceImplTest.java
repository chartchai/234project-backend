package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTest {
    SaleOrderServiceImpl saleOrderService;
    OrderDao orderDao;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOrdersTest(){
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        List<SaleTransaction> transactions = new ArrayList<>();
        mockSaleOrders.add(new SaleOrder("S001",transactions));
        mockSaleOrders.add(new SaleOrder("S002",transactions));
        when(orderDao.getOrders()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getSaleOrders(),hasItem(new SaleOrder("S001",transactions)));
        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder("S001",transactions),
                new SaleOrder("S002",transactions)));
    }

    @Test (expected = AssertionError.class)
    public void testGetSaleOrdersTestNoData(){
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        when(orderDao.getOrders()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getSaleOrders(),is(isNull()));
    }
}
