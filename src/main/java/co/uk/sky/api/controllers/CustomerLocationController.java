/**
 * Rest controller class to expose the customer's location.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.uk.sky.api.services.interfaces.CustomerLocationService;
import co.uk.sky.api.entities.Location;
import co.uk.sky.api.response.Response;

@RestController
@RequestMapping("/api/location")
public class CustomerLocationController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerLocationController.class);
	
	@Autowired
	private CustomerLocationService service;
	
	/**
	 * Get request that returns the location in text format, given a customer ID.
	 * 
	 * @param customerID
	 * @return responseEntity
	 */
	@GetMapping(value = "/{customerID}")
    public ResponseEntity<Response<String>> getLocationID(@PathVariable("customerID") Long customerID) {
		log.info("Getting location ID for customer ID: {}", customerID);
		Response<String> response = new Response<String>();
		
		try {
			Location location = service.getLocation(customerID);
			response.setData(location.getName());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.info("Error fetching location: {}", e.getMessage());
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
    }

}
