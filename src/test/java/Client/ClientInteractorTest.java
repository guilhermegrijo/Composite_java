package Client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import App.AppComponent;
import App.ApplicationModule;
import org.mockito.Mockito.*;
import org.mockito.ArgumentMatchers.*;

import static org.junit.Assert.*;

import Database.DatabaseModule;
import Database.DatabaseRepository;
import Util.Response;
import Util.Status;
import util.ClientGenerator;
import validador.AmountValidator;
import validador.NameValidator;
import validador.ValidatorComposite;

public class ClientInteractorTest {

	@Inject
	FindClientInteractor interactor;
	
	private Client c;
	
	private AppComponentTest testingComponent;
	
	
	
	
	@Before
	public void setup() {
		
		testingComponent = DaggerAppComponentTest.builder()
			    .databaseModule(new DatabaseModule())
			    .applicationModule(new ApplicationModule())
			    .build();
			    
			    testingComponent.inject(this);	
		
	
	
		c = new ClientGenerator().generateNoName();
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void shouldFailedOnSaveClient() throws Throwable {
		
		
		throw interactor.execute(c).error;		
			
	}
	@Test
	public void shouldSaveClient(){
		
		c = new ClientGenerator().generate();
		
		Response response = interactor.execute(c);
		
		assertEquals(response.data,"Salvo");
		
			
	}


@Test
public void shouldFindClient(){
	
	c = new ClientGenerator().generate();
	
	Response response = interactor.execute(c.getName());
	
	assertEquals(response.status, Status.SUCCESS);
	
		
}
}
