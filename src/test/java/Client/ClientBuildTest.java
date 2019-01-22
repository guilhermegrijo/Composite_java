package Client;

import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ClientBuildTest {
	
	
	@Test
	public void ShouldBuildClient() {
		
		Client c = new Client.builder()
						.withName("Guilherme")
						.withBalance(new BigDecimal(200.00))
						.build();
		
		assertEquals("Guilherme",c.getName());
		assertEquals(new BigDecimal(200),c.getBalance());
		
	}

}
