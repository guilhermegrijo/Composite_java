package validator;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import Util.Response;
import util.ClientGenerator;
import validador.AmountValidator;
import validador.Validator;


public class AmountValidatorTest {

	
	
	@Test
	public void test() {
		
		Validator validator = new AmountValidator();
		ClientGenerator client = new ClientGenerator();
		 final ArrayList<Response> response = new ArrayList<Response>();
		
		try {
		validator.validate(client.generate(),new BigDecimal(400.00));
		}
		catch(IllegalArgumentException e){
			//throw new IllegalArgumentException(e);
		}
	}
}
