/**
 * Test class for catalogue's controller IT Tests.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogueControllerIT {
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/catalogue/");
    }
    
    /**
     * Requests a catalogue when an invalid location is given.
     * 
     * @throws Exception
     */
    @Test
    public void getCatalogueWhenInvalidLocation() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "INVALID", String.class);
    	assertThat(response.getBody(), equalTo("{\"data\":null,\"errors\":[\"There's no location for this location ID\"]}"));
    }
    
    /**
     * Requests a catalogue when LONDON's location is given.
     * 
     * @throws Exception
     */
    @Test
    public void getCatalogueWhenLondonLocation() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "LONDON", String.class);
    	assertThat(response.getBody(), equalTo("{\"data\":[{\"id\":1,\"name\":\"Arsenal TV\","
    			+ "\"category\":{\"id\":1,\"name\":\"Sports\"}},{\"id\":2,\"name\":\"Chelsea TV\","
    			+ "\"category\":{\"id\":1,\"name\":\"Sports\"}},{\"id\":4,\"name\":\"Sky News\","
    			+ "\"category\":{\"id\":2,\"name\":\"News\"}},{\"id\":5,\"name\":\"Sky Sports News\","
    			+ "\"category\":{\"id\":2,\"name\":\"News\"}}],\"errors\":[]}"));
    }
    
    /**
     * Requests a catalogue when LIVERPOOL's location is given.
     * 
     * @throws Exception
     */
    @Test
    public void getCatalogueWhenLiverpoolLocation() throws Exception {
    	ResponseEntity<String> response = template.getForEntity(base.toString() + "LIVERPOOL", String.class);
    	assertThat(response.getBody(), equalTo("{\"data\":[{\"id\":3,\"name\":\"Liverpool TV\","
    			+ "\"category\":{\"id\":1,\"name\":\"Sports\"}},{\"id\":4,\"name\":\"Sky News\","
    			+ "\"category\":{\"id\":2,\"name\":\"News\"}},{\"id\":5,\"name\":\"Sky Sports News\","
    			+ "\"category\":{\"id\":2,\"name\":\"News\"}}],\"errors\":[]}"));
    }

}
