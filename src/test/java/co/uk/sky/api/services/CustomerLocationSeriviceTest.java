/**
 * Test class for customer location's service.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.sky.api.entities.Location;
import co.uk.sky.api.services.interfaces.CustomerLocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerLocationSeriviceTest {

	@Autowired
	private CustomerLocationService service;
	
	private static final Long LONDON_CUSTOMER_ID = 1L;
	private static final Long LIVERPOOL_CUSTOMER_ID = 2L;
	private static final Long INVALID_CUSTOMER_ID = 3L;
	
	/**
	 * Tests get a location given null as customer ID.
	 * 
	 * @throws Exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getLocationWhenNullableCustomerID() throws Exception {
		service.getLocation(null);
	}
	
	/**
	 * Tests get a location given an invalid customer ID.
	 * 
	 * @throws Exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getLocationWhenInvalidCustomerID() throws Exception {
		service.getLocation(INVALID_CUSTOMER_ID);
	}
	
	/**
	 * Tests get a location given a LONDON's customer ID.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getLocationLondon() throws Exception {
		Location location = service.getLocation(LONDON_CUSTOMER_ID);
		assertEquals("LONDON", location.getName());
	}
	
	/**
	 * Tests get a location given a LIVERPOOL's customer ID.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getLocationLiverpool() throws Exception {
		Location location = service.getLocation(LIVERPOOL_CUSTOMER_ID);
		assertEquals("LIVERPOOL", location.getName());
	}
	
}
