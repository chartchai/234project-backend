package camt.se234.project.service;

import camt.se234.project.Exceptions.NoDataException;
import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.closeTo;
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

    @Test
    public void testGetAverageSaleOrderPrice(){
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        List<SaleTransaction> transactions = new ArrayList<>();
        List<SaleTransaction> transactions2 = new ArrayList<>();
        transactions.add(new SaleTransaction("T001",new SaleOrder("S001",transactions),
                new Product("D001","Milk","Drink","image/",2500),12));
        mockSaleOrders.add(new SaleOrder("S001",transactions));
        when(orderDao.getOrders()).thenReturn(mockSaleOrders);
        // 2500*12= 30000
        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(closeTo(30000,0.01)));
        transactions.add(new SaleTransaction("T002",new SaleOrder("S001",transactions),
                new Product("D002","Coke","Drink","image/",1500),2));
        // 30000 + 1500*2 = 33000
        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(closeTo(33000,0.01)));
        transactions2.add(new SaleTransaction("T002",new SaleOrder("S002",transactions),
                new Product("D002","Coke","Drink","image/",1500),20));
        mockSaleOrders.add(new SaleOrder("S002",transactions2));
        // (33000 + 1500*20)/2 = 31500
        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(closeTo(31500,0.01)));
    }

    @Test (expected = NoDataException.class)
    public void testGetAverageSaleOrderPriceNoData(){
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        List<SaleTransaction> transactions = new ArrayList<>();
        List<SaleTransaction> transactions2 = new ArrayList<>();
        when(orderDao.getOrders()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(isNull()));
    }
}
