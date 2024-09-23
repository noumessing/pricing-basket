package pricing.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pricing.dao.ManageData;
import pricing.dao.ManageDataImpl;
import pricing.data.InitData;
import pricing.model.CommandLine;
import pricing.model.Product;
import pricing.model.Unity;
import pricing.service.interfaces.CommandLineService;

class CommanLineServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		InitData in = new InitData();
		in.init();
	}

	@Test
	void getQuantityCommandedTest() {

		ManageData md = new ManageDataImpl();

		CommandLineService cls = new CommandLineServiceImpl();
		Product apple = md.getProduct("Apple");
		Product bread = md.getProduct("Bread");
		Product milk = md.getProduct("Milk");

		assertEquals(6, cls.getQuantityCommanded(apple));
		assertEquals(5, cls.getQuantityCommanded(bread));
		assertEquals(5, cls.getQuantityCommanded(milk));

	}

	@Test
	void getPercentageDiscountTest() {

		ManageData md = new ManageDataImpl();

		CommandLineService cls = new CommandLineServiceImpl();

		Product apple = md.getProduct("Apple");
		Unity bag = md.getUnity("Bag");

		double percentage = cls.getPercentageDiscount(apple, bag);

		assertEquals(10.00, percentage);

	}

	
	@Test
	void getAmountDiscountTest() {

		ManageData md = new ManageDataImpl();

		CommandLineService cls = new CommandLineServiceImpl();

		CommandLine clApple = md.getCommandLine(4);

		CommandLine clBread = md.getCommandLine(2); // 0.8

		assertEquals(0.8, cls.getAmountDiscount(clBread));

		 assertEquals(0.6, cls.getAmountDiscount(clApple));

	}
	
	@Test
	void getCommandLinePriceTest() {
		
		ManageData md = new ManageDataImpl();

		CommandLineService cls = new CommandLineServiceImpl();
		
		CommandLine clApple = md.getCommandLine(4);

		CommandLine clBread = md.getCommandLine(2);
		
		assertEquals(6.0, cls.getCommandLinePrice(clApple));
		assertEquals(4.0, cls.getCommandLinePrice(clBread));
		assertNotEquals(5.0, cls.getCommandLinePrice(clApple));
		
	}
	
	@Test
	void getCommandLinePriceWithDiscountTest() {
		
		ManageData md = new ManageDataImpl();

		CommandLineService cls = new CommandLineServiceImpl();
		
		CommandLine clApple = md.getCommandLine(4);

		CommandLine clBread = md.getCommandLine(2);
		
		assertEquals(5.4, cls.getCommandLinePriceWithDiscount(clApple));
		assertEquals(3.2, cls.getCommandLinePriceWithDiscount(clBread));
		assertNotEquals(5.0, cls.getCommandLinePriceWithDiscount(clApple));
		
		
	}

}
