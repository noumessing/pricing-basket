package pricing.dao;

import java.util.List;

import pricing.data.Market;
import pricing.model.CommandLine;
import pricing.model.Discount;
import pricing.model.PriceUnitProduct;
import pricing.model.Product;
import pricing.model.Unity;

//This is a simple implementation of the interface ManageData. Our datas are stored in the collections.
// We can write another implementation for data who are stored in a relational database
public class ManageDataImpl implements ManageData {

	@Override
	public void addProduct(Product prod) {
		Market.products.add(prod);

	}

	@Override
	public void addUnity(Unity unity) {
		Market.unities.add(unity);

	}


	@Override
	public void addCommandLine(CommandLine commandLine) {
		Market.commands.add(commandLine);

	}

	@Override
	public void addPriceUnitProduct(PriceUnitProduct priceUnitProduct) {
		Market.priceUnitProducts.add(priceUnitProduct);
		
	}

	@Override
	public Product getProduct(String nameProduct) {
		Product result = null;
		for (Product prdt : Market.products) {
		     if (prdt.getProductName().equals(nameProduct)) {
		    	 result=prdt;
		    	 break;
		     }
		    }
		
		return result;
		
	}

	@Override
	public double getPriceUnit(Product product, Unity unity) {
		double price = 0;
		
		for (int i=0; i<Market.priceUnitProducts.size(); i++) {
			if (Market.priceUnitProducts.get(i).getProduct().equals(product)&& Market.priceUnitProducts.get(i).getUnity().equals(unity))
			{ price = Market.priceUnitProducts.get(i).getUnitPrice();
			  break;
			}
		}
		
		return price;
		
	}

	@Override
	public Unity getUnity(String nameUnity) {
		Unity result = null;
		for (Unity unity : Market.unities) {
		     if (unity.getUnityName().equals(nameUnity)) {
		    	 result=unity;
		    	 break;
		     }
		    }
		
		return result;
	}
	@Override
	public CommandLine getCommandLine(long idCommandLine) {
		
		CommandLine result = null;
		for (CommandLine cmdL : Market.commands) {
		     if (cmdL.getIdLigneCommande()==idCommandLine) {
		    	 result=cmdL;
		    	 break;
		     }
		    }
		
		return result;
	}

	@Override
	public long getQuantityOfProductInCommand(Product product) {
		
		long quantity = 0;
		
		  for (int i=0; i< Market.commands.size(); i++) {
			  
			  if (Market.commands.get(i).getProduct().equals(product)) {
				  quantity = Market.commands.get(i).getQuantity();
			  }
		  }
		return quantity;
	}

	@Override
	public List<CommandLine> getAllCommands() {
		
		return Market.commands;
	}

	@Override
	public void addDiscount(Discount discount) {
		Market.discounts.add(discount);
		
	}

	@Override
	public Discount getDiscountProduct(Product product, Unity unity) {
		Discount result = null;

		for (int i = 0; i < Market.discounts.size(); i++) {
			if (Market.discounts.get(i).getProductToDiscount().equals(product)
					&& Market.discounts.get(i).getUnityToDiscount().equals(unity)) {
				result = Market.discounts.get(i);
				break;
			}
		}

		return result;
	}
	

}
