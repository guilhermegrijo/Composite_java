package validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import Util.Response;
import util.ClientGenerator;
import validador.AmountValidator;
import validador.NameValidator;
import validador.ValidatorComposite;

public class ValidatorCompositeTest {

	
	
	@Test
	(expected = IllegalArgumentException.class)
	public void shouldFailedOnValidateName() {
		
		ValidatorComposite validator = new ValidatorComposite(Arrays.asList(
				new AmountValidator(),
				new NameValidator()
				));
		
		ClientGenerator client = new ClientGenerator();
		 final ArrayList<Response> response = new ArrayList<Response>();
		
		
		try {
			validator.validate(client.generateNoName());
		}
		catch(IllegalArgumentException e){
			response.add(Response.error(e));
			throw new IllegalArgumentException(e);
		}
		finally {
		for(Response r : response) {
			System.out.println(r.error.getMessage());
		}
		}
	}
	
	@Test
	public void shouldPassOnValidateName() {
		
		ValidatorComposite validator = new ValidatorComposite(Arrays.asList(
				new AmountValidator(),
				new NameValidator()
				));
		
		ClientGenerator client = new ClientGenerator();
		 final ArrayList<Response> response = new ArrayList<Response>();
		
		
		try {
			validator.validate(client.generate());
		}
		catch(IllegalArgumentException e){
			response.add(Response.error(e));
			throw new IllegalArgumentException(e);
		}
		finally {
		for(Response r : response) {
			System.out.println(r.error.getMessage());
		}
		}
	}
	@Test
	//(expected = IllegalArgumentException.class)
	public void ShouldFailedOnValidateAmount() {
		
		ValidatorComposite validator = new ValidatorComposite(Arrays.asList(
				new AmountValidator(),
				new NameValidator()
				));
		
		ClientGenerator client = new ClientGenerator();
		 final ArrayList<Response> response = new ArrayList<Response>();
		
		
		try {
			validator.validate(client.generateNoName(),new BigDecimal(500.00));
		}
		catch(IllegalArgumentException e){
			response.add(Response.error(e));
			//throw new IllegalArgumentException(e);
		}
		finally {
		for(Response r : response) {
			System.out.println(r.error.getMessage());
		}
		}
	}
}
