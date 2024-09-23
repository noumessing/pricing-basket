package pricing.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import pricing.data.Market;

public class Utils {
	
	

	
	public static String formatPrice (double number) {

		String result ="";
		if (number<1) {
			number = number*100;
			BigDecimal bd = new BigDecimal(number).setScale(0, RoundingMode.HALF_UP);
			String newInput = bd.toString();
			result = ""+ newInput+"p";
		} else {
			BigDecimal bd = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
		    double newInput = bd.doubleValue();
		    result = Market.CURRENCY+ newInput;

			
		}
	     
	     return result;
		
	}


}
