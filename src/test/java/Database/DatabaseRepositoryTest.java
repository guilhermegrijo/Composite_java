package Database;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import App.ApplicationModule;
import Client.AppComponentTest;
import Client.Client;
import Client.DaggerAppComponentTest;
import Util.Response;

public class DatabaseRepositoryTest {

	@Inject
	DatabaseRepository repo;
	
	private AppComponentTest testingComponent;
	
	
	@Before
	public void setup() {
		
		testingComponent = DaggerAppComponentTest.builder()
			    .databaseModule(new DatabaseModule())
			    .applicationModule(new ApplicationModule())
			    .build();
			    
			    testingComponent.inject(this);		
		
	
	}
	
	@Test
	public void ShouldFindSingleClient() {
		Response<Client> c = repo.findSingleClient("5ad79e261a2a5430d01e5943");
		
		assertEquals(c.data.getId(),new ObjectId("5ad79e261a2a5430d01e5943"));
		
	}
	
	@Test
	public void ShouldNotFindSingleClient() {
		Response<Client> c = repo.findSingleClient("5ad79e261a2a5430d01e5915");
		
		assertEquals(c.data, null);
	}
}
