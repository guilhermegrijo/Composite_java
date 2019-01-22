package util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import Client.Client;

public class ClientGenerator {

	
	public Client generate() {
		return new Client.builder()
				.withName("Guilherme")
				.withBalance(new BigDecimal(200.00))
				.build();
	}
	
	public List<Client> generateList() {
		List<Client> list = Arrays.asList(new Client.builder()
				.withName("Guilherme")
				.withBalance(new BigDecimal(200.00))
				.build(),
				new Client.builder()
				.withName("Ana")
				.withBalance(new BigDecimal(450.00))
				.build(),
				new Client.builder()
				.withName("Mateus")
				.withBalance(new BigDecimal(300.00))
				.build());		
		return list;
	 
	}
	public Client generateNoName() {
		return new Client.builder()
				.withName("")
				.withBalance(new BigDecimal(200.00))
				.build();
	}
}
