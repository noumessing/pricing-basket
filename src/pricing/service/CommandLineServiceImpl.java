package pricing.service;



import pricing.dao.ManageData;
import pricing.dao.ManageDataImpl;
import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;
import pricing.service.interfaces.CommandLineService;
import pricing.utils.Utils;

public class CommandLineServiceImpl implements CommandLineService {

	private ManageData manageData;

	public CommandLineServiceImpl() {

		manageData = new ManageDataImpl();
	}

	@Override
	public void addProduct(Product prod) {
		manageData.addProduct(prod);

	}

	@Override
	public void addUnity(Unity unity) {
		manageData.addUnity(unity);

	}

	@Override
	public void addCommandLine(CommandLine commandLine) {
		manageData.addCommandLine(commandLine);

	}

	@Override
	public void addPriceUnitProduct(PriceUnitProduct priceUnitProduct) {
		manageData.addPriceUnitProduct(priceUnitProduct);

	}

	@Override
	public void addDiscount(Discount discount) {
		manageData.addDiscount(discount);

	}


	@Override
	public double getPercentageDiscount(Product prod, Unity inity) {

		double percentage = 0;
		Discount discount = manageData.getDiscountProduct(prod, inity);
		if (discount != null) {
			percentage = discount.getPercentageOfDiscount();
		}

		return percentage;
	}



	@Override
	public long getQuantityCommanded(Product product) {

		return manageData.getQuantityOfProductInCommand(product);
	}

	public void outputDiscount(CommandLine commandLine) {

		double amountDiscount = getAmountDiscount(commandLine);
		

		if (amountDiscount != 0) {
	

				System.out.println(commandLine.getProduct().getProductName() + " off:-"
						+ Utils.formatPrice(amountDiscount));
			
		}

	}

	@Override
	public double getCommandLinePrice(CommandLine commandLine) {

		return commandLine.getQuantity() * manageData.getPriceUnit(commandLine.getProduct(), commandLine.getUnity());
	}

	@Override
	public double getCommandLinePriceWithDiscount(CommandLine commandLine) {

		return getCommandLinePrice(commandLine) - getAmountDiscount(commandLine);
	}

	@Override
	public double getAmountDiscount(CommandLine commandLine) {
		double amountDiscount = 0;
		Discount discount = manageData.getDiscountProduct(commandLine.getProduct(), commandLine.getUnity());
		if (discount!=null)
		{
			Product prodToDiscount = discount.getProductToDiscount();  // product who has discount
			Unity unityToDiscount = discount.getUnityToDiscount();
			
			Product ProdGivingDiscount = discount.getProductGivingDiscount(); //// product to buy before having discount
			Unity unityGivingDiscount = discount.getUnityOfGivingDiscount();
			
			 if (!prodToDiscount.equals(ProdGivingDiscount)){
				 long numberOfProductGivingDiscount = getQuantityCommanded(ProdGivingDiscount); //the quantity of product giving discount to the other product
				 long quantitydiscount = numberOfProductGivingDiscount / discount.getQuantityGivendiscount(); 
				 long numberOfProductCommanded = commandLine.getQuantity();
				 
				 if (quantitydiscount>0) 
				  {
					 if ((numberOfProductCommanded - quantitydiscount) >= 0) 
					 {
						 amountDiscount = quantitydiscount * manageData.getPriceUnit(prodToDiscount, commandLine.getUnity())*discount.getPercentageOfDiscount()/100;
									
					 } else {
						 
						 amountDiscount =numberOfProductCommanded* manageData.getPriceUnit(prodToDiscount, commandLine.getUnity())*discount.getPercentageOfDiscount()/100;
						 
					 		}
					}
			 }else if ((prodToDiscount.equals(ProdGivingDiscount))&&(unityToDiscount.equals(unityGivingDiscount)))
			 {
				 
				 amountDiscount=getCommandLinePrice(commandLine)*discount.getPercentageOfDiscount()/100;
				 
			 }
			
		}
			return amountDiscount;
	}

}
