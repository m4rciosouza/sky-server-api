/**
 * Test class for catalogue's controller.
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
public class CatalogueControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	/**
	 * Requests a catalogue given an invalid location.
	 * 
	 * @throws Exception
	 */
	@Test
    public void getCatalogueWhenInvalidLocation() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/catalogue/INVALID").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
	
	/**
	 * Requests a catalogue given LONDON's location.
	 * 
	 * @throws Exception
	 */
	@Test
    public void getCatalogueWhenLondonLocation() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/catalogue/LONDON").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'data':[{'id':1,'name':'Arsenal TV','category':{'id':1,'name':'Sports'}},"
                		+ "{'id':2,'name':'Chelsea TV','category':{'id':1,'name':'Sports'}},"
                		+ "{'id':4,'name':'Sky News','category':{'id':2,'name':'News'}},"
                		+ "{'id':5,'name':'Sky Sports News','category':{'id':2,'name':'News'}}],'errors':[]}"));
    }
	
	/**
	 * Requests a catalogue given LIVERPOOL's location.
	 * 
	 * @throws Exception
	 */
	@Test
    public void getCatalogueWhenLiverpoolLocation() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/catalogue/LIVERPOOL").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'data':[{'id':3,'name':'Liverpool TV','category':{'id':1,'name':'Sports'}},"
                		+ "{'id':4,'name':'Sky News','category':{'id':2,'name':'News'}},"
                		+ "{'id':5,'name':'Sky Sports News','category':{'id':2,'name':'News'}}],'errors':[]}"));
    }

}
