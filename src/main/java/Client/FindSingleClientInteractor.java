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
public class FindSingleClientInteractor {

	private DatabaseRepository repository;

	private ClientMapper mapper;

	
	private Validator validator;
	

	@Inject
	public FindSingleClientInteractor(DatabaseRepository repository, ClientMapper mapper,@Named("SaveClientValidator")ValidatorComposite validator) {
		this.repository = repository;
		this.mapper = mapper;
		this.validator = validator;
	}

	public Response execute(String code) {

		try {
			repository.findSingleClient(code);
		} catch (IllegalArgumentException e) {
			return Response.error(e);
		}
		return null;

	}

}
