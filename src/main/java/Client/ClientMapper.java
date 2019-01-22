package Client;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.bson.Document;

@Singleton
public class ClientMapper {
	
	@Inject
	public ClientMapper() {
		
	}
	
	
	public Document clientToDocument(Client c) {
		
		return new Document("name",c.getName())
				.append("balance", c.getBalance());
	}
public Client documentToClient(Document c) {
		
		return new Client.builder()
				.withName(c.getString("name"))
				.withId(c.getObjectId("_id"))
				.withBalance(new BigDecimal(c.get("balance").toString()))
				.build();
	}
	
}
