package pricing.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilsTest {

	
	
	@Test
	void formatPriceTest() {
		
		double input = 3.14159265359;
		double input2 = 15.2;
		
	    assertEquals("£3.14", Utils.formatPrice(input));
		assertEquals("£15.2", Utils.formatPrice(input2));
		
	}

}
