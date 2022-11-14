package tn.esprit.rh.achat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Stock;
import static org.junit.Assert.*;

import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplMock {
	
	 @Mock
     StockRepository stockrepository;
	 @InjectMocks
	 StockServiceImpl stockserivce;
	 @Autowired 
	 IStockService st;
	 
	 
	// cree des stocks pour tester 
	 
	 Stock s = new Stock("stock_test",5,10);
	 Stock s1 = new Stock("stock_test1",2,10);
	 
	 List<Stock> stockList = Arrays.asList(s,s1);
	 
	 @Test
	    @Order(1)
	    public void TestAddStock() {
	        log.info("Test add stock");
	        when(stockrepository.save(s)).thenReturn(s);
	        Stock created =stockserivce.addStock(s);
	        Assertions.assertEquals(created.getLibelleStock(),(s.getLibelleStock()));
	        log.info("Stock"+s.getLibelleStock()+"added succesfully");
	    }
	 @Test
	    @Order(2)
	    public void  TestRetrieveAllStocks() {
	        log.info("Test Retrive All stocks");
	        when(stockrepository.findAll()).thenReturn(stockList);
	        List<Stock> stockList = stockserivce.retrieveAllStocks();
	        Assertions.assertNotNull(stockList);
	        log.info("Retrieve All Stocks Works !");
	 }

	 	@Test
	 	@Order(3)
	 	public void TestUpdateStock() {
	 	log.info("Test Update stock");
        when(stockrepository.save(s)).thenReturn(s);
        assertNotNull(s);
        assertEquals(s, stockserivce.updateStock(s));
        log.info("Stock updated succesfully !");
    }
}