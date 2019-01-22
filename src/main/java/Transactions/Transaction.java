package Transactions;

import java.math.BigDecimal;

import org.bson.types.ObjectId;

import Client.Client;
import Database.Database;

public class Transaction implements Database {
	
	private ObjectId id;
	private Client fromClient;
	private Client toClient;
	private BigDecimal amount;

	public Client getFromClientID() {
		return fromClient;
	}
	public void setFromClient(Client fromClient) {
		this.fromClient = fromClient;
	}
	public Client getToClient() {
		return toClient;
	}
	public void setToClient(Client toClient) {
		this.toClient = toClient;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
