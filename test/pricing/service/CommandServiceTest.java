package pricing.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pricing.data.InitData;
import pricing.service.interfaces.CommandService;

class CommandServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		InitData in = new InitData();
		in.init();
	}
	
	@Test
	 void getSubtotalTest() {
		 
		 CommandService cs = new CommandServiceImpl();
		 assertEquals(19.75, cs.getSubtotal());
		 		 
	 }
	@Test
	void getTotalDiscountTest() {
		 CommandService cs = new CommandServiceImpl();
		 assertEquals(1.4, cs.getTotalDiscount());
		
	}
	@Test
	void getTotalPriceTest() {
		CommandService cs = new CommandServiceImpl();
		 assertEquals(18.35, cs.getTotalPrice());
		
	}

}
