package validador;

import java.math.BigDecimal;
import java.util.List;

import Client.Client;

public class ValidatorComposite implements Validator {

	private final List<Validator> validators;

	public ValidatorComposite(List<Validator> validators) {
		this.validators = validators;
	}

	@Override
	public void validate(Client c) {
		validators.forEach(validator -> validator.validate(c));

	}

	@Override
	public void validate(Client c, BigDecimal amount) {

		validators.forEach(validator -> validator.validate(c, amount));

	}
}
