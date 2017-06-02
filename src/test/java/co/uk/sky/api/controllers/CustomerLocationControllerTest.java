/**
 * Test class for customer location's controller.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerLocationControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	/**
	 * Requests a location given an invalid customer ID.
	 * 
	 * @throws Exception
	 */
	@Test
    public void getInvalidCustomerID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/location/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

	/**
	 * Requests a location given LONDON's customer ID.
	 * 
	 * @throws Exception
	 */
    @Test
    public void getLocationLondon() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/location/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'data':'LONDON','errors':[]}"));
    }
    
    /**
	 * Requests a location given LIVERPOOL's customer ID.
	 * 
	 * @throws Exception
	 */
    @Test
    public void getLocationLiverpool() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/location/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'data':'LIVERPOOL','errors':[]}"));
    }
    
}
