package validador;

import java.math.BigDecimal;
import java.util.Optional;

import Client.Client;

public class NameValidator implements Validator {

	public void validate(Client c) {

		Optional.ofNullable(c)
				.map(Client::getName)
				.filter(name -> name.length() != 0)
				.orElseThrow(() -> new IllegalArgumentException("Um nome deve ser disponibilizado"));
			
		
	}

	@Override
	public void validate(Client c,BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}


}
