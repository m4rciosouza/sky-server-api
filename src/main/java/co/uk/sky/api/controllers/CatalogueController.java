/**
 * Rest controller class to expose the catalogue.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.uk.sky.api.entities.Product;
import co.uk.sky.api.response.Response;
import co.uk.sky.api.services.interfaces.CatalogueService;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogueController.class);
	
	@Autowired
	private CatalogueService service;
	
	/**
	 * Get request that returns the catalogue information by location.
	 * 
	 * @param locationID
	 * @return responseEntity
	 */
	@GetMapping(value = "/{locationID}")
    public ResponseEntity<Response<List<Product>>> getCatalogue(@PathVariable("locationID") String locationID) {
		log.info("Getting catalogue for location ID: {}", locationID);
		Response<List<Product>> response = new Response<List<Product>>();
		
		try {
			List<Product> products = service.getCatalogue(locationID);
			response.setData(products);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.info("Error fetching catalogue: {}", e.getMessage());
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
    }

}
