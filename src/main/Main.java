package main;

import java.util.List;


import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;
import pricing.service.CommandLineServiceImpl;
import pricing.service.CommandServiceImpl;
import pricing.service.interfaces.CommandService;
import pricing.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		CommandLineServiceImpl cls = new CommandLineServiceImpl();
		
		CommandService cs = new CommandServiceImpl();
		
		//Creating goods (product)
		Product soup = new Product(1,"Soup");
		
		Product bread = new Product(2,"Bread");
		
		Product milk = new Product(3,"Milk");
		
		Product apple = new Product(4,"Apple");
		
		//Inserting product in database
		cls.addProduct(soup);
		cls.addProduct(bread);
		cls.addProduct(milk);
		cls.addProduct(apple);
		
		//Creating Unity
		Unity tin = new Unity(1,"Tin");
		Unity loaf = new Unity(2,"Loaf");
		Unity bottle = new Unity(3,"Bottle");
		Unity bag = new Unity(4,"Bag");
		
		//Inserting Unity in database
		cls.addUnity(tin);
		cls.addUnity(loaf);
		cls.addUnity(bottle);
		cls.addUnity(bag);
		
		
		//Creating price of product per Unit
		PriceUnitProduct tinOfSoup = new PriceUnitProduct(1,soup,tin,0.65);
		
		PriceUnitProduct loafOfBread = new PriceUnitProduct(2,bread,loaf,0.80);
		
		PriceUnitProduct bottleOfMilk = new PriceUnitProduct(3,milk,bottle,1.30);
		
		PriceUnitProduct bagOfApple = new PriceUnitProduct(4,apple,bag,1.00);
		
		//Inserting price unity in database
		cls.addPriceUnitProduct(tinOfSoup);
		cls.addPriceUnitProduct(loafOfBread);
		cls.addPriceUnitProduct(bottleOfMilk);
		cls.addPriceUnitProduct(bagOfApple);
		
		//Creating items (commandLine)
		CommandLine soupCommand =new CommandLine();
		soupCommand.setIdLigneCommande(1);
		soupCommand.setProduct(soup);
		soupCommand.setUnity(tin);
		soupCommand.setQuantity(5);
		
		CommandLine breadCommand =new CommandLine();
		breadCommand.setIdLigneCommande(2);
		breadCommand.setProduct(bread);
		breadCommand.setUnity(loaf);
		breadCommand.setQuantity(5);
		
		CommandLine milkCommand =new CommandLine();
		milkCommand.setIdLigneCommande(3);
		milkCommand.setProduct(milk);
		milkCommand.setUnity(bottle);
		milkCommand.setQuantity(5);
		
		CommandLine appleCommand =new CommandLine();
		appleCommand.setIdLigneCommande(4);
		appleCommand.setProduct(apple);
		appleCommand.setUnity(bag);
		appleCommand.setQuantity(6);

		// Inserting Items in basket (command line in the database)
		cls.addCommandLine(soupCommand);
		cls.addCommandLine(breadCommand);
		cls.addCommandLine(milkCommand);
		cls.addCommandLine(appleCommand);
		
		//Creating discount parameters

		//Buy 2 tins of soup and get a loaf of bread for half price
		//The product to discount is bread
		//The product to buy to have a discount of bread is soup (tin of soup)
		//
		Discount discountBread = new Discount();
		discountBread.setIdDiscount(1);
		discountBread.setProductToDiscount(bread); // product who has discount
		discountBread.setUnityToDiscount(loaf);
		discountBread.setProductGivingDiscount(soup); // product to buy before having discount
		discountBread.setUnityOfGivingDiscount(tin);
		discountBread.setQuantityGivendiscount(2); // buy 2 tin o soup
		discountBread.setQuantityToDiscount(1); // get a loaf of bread 
		discountBread.setPercentageOfDiscount(50); // half price (50% of discount)
		
		
		// Apples have a 10% discount off their normal price this week
		// in this case the product to buy and the product to discount are the same
		Discount discountApple = new Discount();
		discountApple.setIdDiscount(2);
		discountApple.setProductToDiscount(apple);
		discountApple.setUnityToDiscount(bag);
		discountApple.setProductGivingDiscount(apple);
		discountApple.setUnityOfGivingDiscount(bag);
		discountApple.setQuantityGivendiscount(1);
		discountApple.setQuantityToDiscount(1);
		discountApple.setPercentageOfDiscount(10); // percentage of discount of the product
		
		

		//Inserting discount parameters in database
		cls.addDiscount(discountBread);
		cls.addDiscount(discountApple);
		
		
		
		
		List<CommandLine>  items = cs.getAllCommands();
		System.out.println("###########################################################");
		System.out.println("###########################################################");
		
		System.out.print("######        PriceBasket ");
		
		for (CommandLine cml : items) {
			
			System.out.print(cml.getProduct().getProductName() + " ");
			
		}
		System.out.println("     ######");
		System.out.println("###########################################################");
		for (CommandLine cml : items) {
			
			System.out.println(cml.getProduct().getProductName() + ": " +Utils.formatPrice(cls.getCommandLinePrice(cml)));
			
			
		}
		System.out.println("Subtotal:" + Utils.formatPrice(cs.getSubtotal()));
		if (cs.getTotalDiscount()>0) {
			for (CommandLine cml : items) {
				cls.outputDiscount(cml);
				
			}}
		else {
			System.out.println("(No offers available)");
		}
		System.out.println("Total price:" + Utils.formatPrice(cs.getTotalPrice()));
	    

		
	}

}
