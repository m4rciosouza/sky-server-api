/**
 * Service interface for customer location.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services.interfaces;

import co.uk.sky.api.entities.Location;

public interface CustomerLocationService {

	/**
	 * Gets and return the location given a customer ID.
	 * 
	 * @param customerID
	 * @return location
	 * @throws Exception
	 */
	Location getLocation(Long customerID) throws Exception;
	
}
