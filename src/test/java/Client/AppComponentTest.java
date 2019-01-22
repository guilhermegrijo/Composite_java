package Client;
import javax.inject.Named;
import javax.inject.Singleton;

import com.mongodb.client.MongoDatabase;

import App.ApplicationModule;
import Client.ClientInteractorTest;
import Client.ClientMapper;
import Database.DatabaseModule;
import Database.DatabaseRepositoryTest;
import dagger.Component;
import validador.ValidatorComposite;

@Singleton
@Component(modules={DatabaseModule.class,ApplicationModule.class})
public interface AppComponentTest {
			

	void inject(ClientInteractorTest setup);

	void inject(DatabaseRepositoryTest setup);
	
	ClientMapper mapper();
	
	@Named("SaveClientValidator")
	ValidatorComposite validator();

	
	
	

}
