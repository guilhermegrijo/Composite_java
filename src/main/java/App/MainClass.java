package App;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import Client.Client;
import Client.SaveClientInteractor;
import Database.DatabaseModule;
import Ui.MainView;
import dagger.Component;

public class MainClass {





	public static void main(String[] args) {		
		AppComponent component;
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); 
		
		component = DaggerAppComponent.builder()
				.databaseModule(new DatabaseModule())
				.applicationModule(new ApplicationModule())
				.build();
		
		MainView view = new MainView(component);
		
		
	

	}
	


}
