import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class CalculatorTest {
	
	@Test
	public void result_is_initialized_to_zero_by_no_arg_constructor() {
		Calculator calculator = new Calculator();
		int result = calculator.getResult();
		assertEquals(0, result);
	}
	
	@Test
	public void result_is_initialized_to_supplied_value_by_one_arg_constructor() {
		Calculator calculator = new Calculator(3);
		int result = calculator.getResult();
		assertEquals(3, result);
	}
	
	@Test
	public void adds_and_returns_the_running_result() {
		Calculator calculator = new Calculator();
		int result = calculator.add(1);
		assertEquals("added 1", 1, result);
		result = calculator.add(3);
		assertEquals("added 3 to 1", 4, result);
	}
	
	@Test
	public void keeps_track_of_running_results_after_addition() {
		Calculator calculator = new Calculator();
		calculator.add(4);
		calculator.add(8);
		int result = calculator.getResult();
		assertEquals("added 4 to 8", 12, result);
	}
	
	@Test
	public void subtracts_and_returns_the_running_result() {
		Calculator calculator = new Calculator(10);
		int result = calculator.subtract(3);
		assertEquals("subtracted 3 from 10", 7, result);
		result = calculator.subtract(5);
		assertEquals("subtracted 5 from 7", 2, result);
	}
	
	@Test
	public void keeps_track_of_running_results_after_subtraction() {
		Calculator calculator = new Calculator(10);
		calculator.subtract(1);
		calculator.subtract(8);
		int result = calculator.getResult();
		assertEquals("subtracted 1 and 8 from 10", 1, result);
	}
	
	@Test
	public void multiplies_and_returns_the_running_result() {
		Calculator calculator = new Calculator(2);
		int result = calculator.multiply(2);
		assertEquals("multiplied 2 by 2", 4, result);
		result = calculator.multiply(5);
		assertEquals("multiplied 4 by 5", 20, result);
	}
	
	@Test
	public void keeps_track_of_running_results_after_multiplication() {
		Calculator calculator = new Calculator(2);
		calculator.multiply(5);
		calculator.multiply(10);
		int result = calculator.getResult();
		assertEquals("multiplied 2 by 5 and 10", 100, result);
	}
	
	@Test
	public void raises_result_by_an_exponent_and_returns_the_result() {
		Calculator calculator = new Calculator(2);
		int result = calculator.power(2);
		assertEquals("raised 2 by power 2", 4, result);
		result = calculator.power(3);
		assertEquals("raised 4 by power 3", 64, result);
	}

	@Test
	public void keeps_track_of_running_results_after_exponentiation() {
		Calculator calculator = new Calculator(2);
		calculator.power(2);
		calculator.power(3);
		int result = calculator.getResult();
		assertEquals("power 2 by power 2 then by power 3", 64, result);
	}
	
	@Test
	public void raising_to_power_of_one_gives_same_result() {
		Calculator calculator = new Calculator(5);
		int result = calculator.power(1);
		assertEquals("raised 5 by power 1", 5, result);
		result = calculator.getResult();
		assertEquals("raised 5 by power 1", 5, result);
	}
	
	@Test
	public void raising_to_power_of_zero_gives_result_of_1() {
		Calculator calculator = new Calculator(5);
		int result = calculator.power(0);
		assertEquals("raised 5 by power 0", 1, result);
		result = calculator.getResult();
		assertEquals("raised 5 by power 0", 1, result);
	}
	
	@Test
	public void treats_a_negative_exponent_as_positive() {
		Calculator calculator = new Calculator(2);
		int result = calculator.power(-3);
		assertEquals("raised 2 by power -3 expecting it to be treated as power 3", 8, result);
	}
	
	@Test
	public void reset_sets_the_result_to_zero() {
		Calculator calculator = new Calculator(5);
		calculator.reset();
		int result = calculator.getResult();
		assertEquals(0, result);
	}
}