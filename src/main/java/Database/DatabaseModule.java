package Database;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import javax.inject.Singleton;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import dagger.Module;
import dagger.Provides;
import Util.DatabaseURI;

@Module
public class DatabaseModule {

	@Singleton
	@Provides
	public CodecRegistry providePojoCodecRegister() {
		CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		return codecRegistry;
		
	}

	@Singleton
	@Provides
	public MongoClientURI provideMongoClientURI() {
		MongoClientURI uri = new MongoClientURI(DatabaseURI.URI);
		return uri;
	}
	
	
	@Singleton
	@Provides
	public MongoClient provideMongoClient(MongoClientURI uri) {
		MongoClient mongoClient = new MongoClient(uri);
		return mongoClient;
	}
	
	@Singleton
	@Provides
	public MongoDatabase provideMongoDatabase(MongoClient mongoClient, CodecRegistry codecRegistry){
		MongoDatabase database = mongoClient.getDatabase("bank").withCodecRegistry(codecRegistry);		
		
		return database;
		
	}
	
}
