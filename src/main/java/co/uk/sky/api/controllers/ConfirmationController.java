/**
 * Rest controller class to expose the confirmation checkout action. 
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.uk.sky.api.response.Response;

@RestController
@RequestMapping("/api/confirmation")
public class ConfirmationController {

	private static final Logger log = LoggerFactory.getLogger(ConfirmationController.class);

	/**
	 * Post request that receives the customer ID, and products IDs, 
	 * in order to process the checkout action.
	 * This is a stub method, so it not process the checkout, only prints 
	 * the data.
	 * 
	 * @param customerID
	 * @param productsID
	 * @return responseEntity
	 */
	@PostMapping
	public ResponseEntity<Response<Map<String, String>>> getConfirmation(
			@Param("customerID") String customerID,
			@Param("productsID") String productsID) {
		log.info("Confirming page for customer ID: {}, and products IDs {}", customerID, productsID);
		Response<Map<String, String>> response = new Response<Map<String, String>>();
		
		Map<String, String> data = new HashMap<>();
		data.put("customerID", customerID);
		data.put("productsID", productsID);
		
		response.setData(data);

		return ResponseEntity.ok(response);
	}

}
