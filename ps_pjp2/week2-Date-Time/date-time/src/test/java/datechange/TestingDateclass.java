package datechange;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class TestingDateclass {
	
	@Test
	void test() throws ParseException {
		addDates a=new addDates();
		assertEquals("09-2-3000", a.addDate("00-00-1000", "10-02-2000", 1));
		 
		
	}

}
