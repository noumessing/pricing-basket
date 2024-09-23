package pricing.service.interfaces;

import java.util.List;

import pricing.model.CommandLine;

public interface CommandService {
	
	//The amount of basket without discount
	double getSubtotal();
	
	//The amount of basket with eventual discount
	double getTotalPrice();
	
	//The amount of discounts
	double getTotalDiscount();
	
	List<CommandLine> getAllCommands();

}
