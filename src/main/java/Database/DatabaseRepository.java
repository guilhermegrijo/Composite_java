package Database;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import Client.Client;
import Util.Response;

@Singleton
public class DatabaseRepository implements Repository {
	

	MongoDatabase db;

	@Inject
	public DatabaseRepository(MongoDatabase mongoDb) {
		this.db = mongoDb;
		
	}

	public Response saveClient(Client client) {
		
		try {
			db.getCollection("Client", Client.class).insertOne(client);
						
		} catch (MongoException e) {
			return Response.error(e);
		}

		return Response.sucess("Salvo");

	}
	
	public MongoCursor findClientByName(String name) {

		Pattern pattern = Pattern.compile(".*"+Pattern.quote(name)+".*", Pattern.CASE_INSENSITIVE);
	
		return db.getCollection("Client", Client.class).find(new BasicDBObject("name",pattern)).iterator();
	
	}
	
	public Response<Client> findSingleClient(String code){
		Client client;
		try {
		 client = db.getCollection("Client",Client.class).find(new BasicDBObject("_id",new ObjectId(code))).first();
		client.getId();
		}
		catch(MongoException e) {
			return Response.error(e);
		}
		catch(NullPointerException e) {
			return Response.error(e);
		}
		return Response.sucess(client);
	
	
		
	}
	
	
	

}
