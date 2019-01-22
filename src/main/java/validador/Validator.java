package validador;

import java.math.BigDecimal;

import Client.Client;

public interface Validator {
	
	
	public void validate(Client c);
	
	public void validate(Client c, BigDecimal amount);

}
