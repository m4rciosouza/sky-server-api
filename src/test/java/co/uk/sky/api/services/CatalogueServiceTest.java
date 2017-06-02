/**
 * Test class for catalogue's service.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.uk.sky.api.entities.Product;
import co.uk.sky.api.services.interfaces.CatalogueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogueServiceTest {

	@Autowired
	private CatalogueService service;
	
	/**
	 * Tests get a catalogue given null as location.
	 * 
	 * @throws Exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getCatalogueWhenNullableLocation() throws Exception {
		service.getCatalogue(null);
	}
	
	/**
	 * Tests get a catalogue given an invalid location.
	 * 
	 * @throws Exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getCatalogueWhenInvalidLocation() throws Exception {
		service.getCatalogue("INVALID");
	}
	
	/**
	 * Tests get a catalogue given LONDON's location.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCatalogueWhenLondonLocation() throws Exception {
		List<Product> products = service.getCatalogue("LONDON");
		assertEquals(4, products.size());
	}
	
	/**
	 * Tests get a catalogue given LIVERPOOL's location.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCatalogueWhenLiverpoolLocation() throws Exception {
		List<Product> products = service.getCatalogue("LIVERPOOL");
		assertEquals(3, products.size());
	}
	
}
