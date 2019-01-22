# Composite_java
Aplicação de teste para testar uma forma de validação usando Composite


Composite
```Java
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
 ```
 Método utilizando
 ```Java
 	@Inject
	public SaveClientInteractor(DatabaseRepository repository, ClientMapper mapper,@Named("SaveClientValidator")ValidatorComposite validator) {
		this.repository = repository;
		this.mapper = mapper;
		this.validator = validator;
	}

	public Response execute(Client c) {

		try {
			validator.validate(c);
		} catch (IllegalArgumentException e) {
			return Response.error(e);
		}
		return repository.saveClient(c);

	}
  ```
  Exemplo de validador
  
 ```Java
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
```
