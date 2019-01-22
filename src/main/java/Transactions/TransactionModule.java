package Transactions;

import javax.inject.Singleton;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class TransactionModule {

	
	@Singleton
	@Provides
	public MongoCollection<Transaction> provideMongoCollection(MongoDatabase mongoDB){
		MongoCollection<Transaction> collection = mongoDB.getCollection("transaction",Transaction.class);
		return collection;			
	}
	
	
}
