package App;

import javax.inject.Named;
import javax.inject.Singleton;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Client.Client;
import Client.ClientMapper;
import Database.Database;
import Database.DatabaseModule;
import Database.DatabaseRepository;
import Ui.FindClientView;
import dagger.Component;
import validador.ValidatorComposite;

@Singleton
@Component(modules = { DatabaseModule.class, ApplicationModule.class })
public interface AppComponent {

	void inject(FindClientView view);

	ClientMapper mapper();

	@Named("SaveClientValidator")
	ValidatorComposite validator();
	
	MongoDatabase database();

}
