package Client;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import Database.DatabaseRepository;
import Client.ClientMapper;
import Util.Response;
import validador.Validator;
import validador.ValidatorComposite;

@Singleton
public class SaveClientInteractor {

	private DatabaseRepository repository;

	private ClientMapper mapper;

	
	private Validator validator;
	

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

}
