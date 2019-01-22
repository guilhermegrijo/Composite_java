package Client;

import java.math.BigDecimal;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import Database.Database;


@BsonDiscriminator
public class Client implements Database{
	
	public ObjectId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	private final ObjectId id;
	private final String name;
	private final BigDecimal balance;
	
	
	 
    @BsonCreator
	public Client(@BsonProperty("id") ObjectId id,@BsonProperty("name") String name,@BsonProperty("balance") BigDecimal balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public static class builder{
		
		private ObjectId id;
		private String name;
		private BigDecimal balance;
		
		public builder withId(ObjectId id) {
			this.id=id;
			return this;
		}
		
		public builder withName(String name) {
			this.name=name;
			return this;
		}
		public builder withBalance(BigDecimal balance) {
			this.balance=balance;
			return this;
		}
		
		public Client build() {
			return new Client(this);
		}
		
	}
	
	private Client(builder build) {
	 this.id = build.id;
	 this.name = build.name;
	 this.balance = build.balance;
	}
	
	@Override
	public String toString() {
		return "Código: "+id+" Nome: "+name;
		
	}

}
