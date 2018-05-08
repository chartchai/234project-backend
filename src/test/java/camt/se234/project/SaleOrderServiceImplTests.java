package camt.se234.project;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.SaleOrderServiceImpl;

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
    public void setup() {
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);

    }

    @Test
    public void testGetSaleOrders() {
        List<SaleOrder> mockOrders = new ArrayList<>();
        List<SaleTransaction> mockTransactions = new ArrayList<>();


        mockOrders.add(new SaleOrder("S0001", mockTransactions));
        mockOrders.add(new SaleOrder("S0002", mockTransactions));
        mockOrders.add(new SaleOrder("S0003", mockTransactions));

        mockTransactions.add(new SaleTransaction("t001", new SaleOrder(),
                new Product("000001L", "p1", "product1", "p1.jpg", 100.0), 10));

        mockTransactions.add(new SaleTransaction("t002", new SaleOrder(),
                new Product("000001L", "p1", "product1", "p1.jpg", 100.0), 20));

        when(orderDao.getOrders()).thenReturn(mockOrders);

        assertThat(saleOrderService.getSaleOrders(), hasItems(
                new SaleOrder("S0001", mockTransactions),
                new SaleOrder("S0002", mockTransactions),
                new SaleOrder("S0003", mockTransactions)
        ));
    }

    @Test
    public void testGetAverageSaleOrderPrice() {
        List<SaleOrder> mockOrders = new ArrayList<>();
        List<SaleTransaction> mockTransactions = new ArrayList<>();
        List<SaleTransaction> mockTransactions2 = new ArrayList<>();
        mockTransactions.add(new SaleTransaction("t001", new SaleOrder(),
                new Product("000001L", "p1", "product1", "p1.jpg", 100.0), 10));
        mockTransactions.add(new SaleTransaction("t002", new SaleOrder(),
                new Product("000002L", "p2", "product12", "p2.jpg", 50.0), 20));
        mockTransactions2.add(new SaleTransaction("t001", new SaleOrder(),
                new Product("0000011L", "p11", "product11", "p11.jpg", 110.0), 10));
        mockTransactions2.add(new SaleTransaction("t002", new SaleOrder(),
                new Product("0000021L", "p21", "product21", "p21.jpg", 51.0), 20));

        mockOrders.add(new SaleOrder("S0001", mockTransactions));
        mockOrders.add(new SaleOrder("S0002", mockTransactions2));
        when(orderDao.getOrders()).thenReturn(mockOrders);
        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(2060.0));
    }
}
