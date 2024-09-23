package pricing.service;

import java.util.List;

import pricing.dao.ManageData;
import pricing.dao.ManageDataImpl;
import pricing.model.CommandLine;
import pricing.service.interfaces.CommandService;

public class CommandServiceImpl implements CommandService{
	
	private ManageData manageData;

	public CommandServiceImpl() {
		
		manageData = new ManageDataImpl();
	}
	//The amount of basket without discount
	@Override
	public double getSubtotal() {
		CommandLineServiceImpl cls = new CommandLineServiceImpl();
		
		var result = manageData.getAllCommands().stream().map(cmd -> cls.getCommandLinePrice(cmd)).reduce(0.0, Double::sum);
		
		return result;
	}
	//The amount of basket with eventual discount
	@Override
	public double getTotalPrice() {
		
		return getSubtotal() - getTotalDiscount();
	}
	//The amount of discounts
	@Override
	public double getTotalDiscount() {
		CommandLineServiceImpl cls = new CommandLineServiceImpl();
		var result = manageData.getAllCommands().stream().map(cmd -> cls.getAmountDiscount(cmd)).reduce(0.0,Double::sum);

		return result;
	}

	@Override
	public List<CommandLine> getAllCommands() {
		
		return manageData.getAllCommands();
	}

}
