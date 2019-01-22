package validador;

import java.math.BigDecimal;
import java.util.Optional;

import Client.Client;

public class AmountValidator implements Validator {

	public void validate(Client c,BigDecimal amount) {

		Optional.ofNullable(c)
				.map(Client::getBalance)
				.filter(Amount -> Amount.compareTo(amount) >= 0)
				.orElseThrow(() -> new IllegalArgumentException("Saldo indisponivel"));
			
		
	}

	@Override
	public void validate(Client c) {
		// TODO Auto-generated method stub
		
	}


}
