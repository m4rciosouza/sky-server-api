/**
 * Test class for customer location's controller IT Tests.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerLocationControllerIT {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/location/");
    }
    
    /**
     * Requests a location when an invalid customer is given.
     * 
     * @throws Exception
     */
    @Test
    public void getLocationWhenInvalidCustomer() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "3", String.class);
    	assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Requests a location when LONDON's customer is given.
     * 
     * @throws Exception
     */
    @Test
    public void getLocationWhenLondonCustomer() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "1", String.class);
    	assertThat(response.getBody(), equalTo("{\"data\":\"LONDON\",\"errors\":[]}"));
    }
    
    /**
     * Requests a location when LIVERPOOL's customer is given.
     * 
     * @throws Exception
     */
    @Test
    public void getLocationWhenLiverpoolCustomer() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "2", String.class);
    	assertThat(response.getBody(), equalTo("{\"data\":\"LIVERPOOL\",\"errors\":[]}"));
    }

}
