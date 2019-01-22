package Client;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import Database.Database;
import Database.DatabaseRepository;
import Client.ClientMapper;
import Util.Response;
import validador.Validator;
import validador.ValidatorComposite;

@Singleton
public class FindClientInteractor {

	private DatabaseRepository repository;

	private ClientMapper mapper;

	private Validator validator;

	@Inject
	public FindClientInteractor(DatabaseRepository repository, ClientMapper mapper,
			@Named("SaveClientValidator") ValidatorComposite validator) {
		this.repository = repository;
		this.mapper = mapper;
		this.validator = validator;
	}

	public Response<List<Client>> execute(String c) {
		List<Client> result = new ArrayList<>();

		try {
			if (c == null || c.isEmpty()) {
				throw new RuntimeException("Nome não pode ser vazio");

			}
			
			MongoCursor<Client> cursor = repository.findClientByName(c);

			while (cursor.hasNext()) {
				
				Client client = cursor.next();
				result.add(client);

			}
			
			return Response.sucess(result);

		} catch (IllegalArgumentException e) {
			
			return Response.error(e);
			
		} catch (RuntimeException e) {
			
			return Response.error(e);
			
		}

	}

}
