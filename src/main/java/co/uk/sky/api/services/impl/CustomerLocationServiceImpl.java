/**
 * Customer location service implementation.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services.impl;

import co.uk.sky.api.entities.Location;
import co.uk.sky.api.repositories.LocationRepository;
import co.uk.sky.api.services.interfaces.CustomerLocationService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLocationServiceImpl implements CustomerLocationService {
	
	@Autowired
	private LocationRepository repository;

	@Override
	public Location getLocation(Long customerID) throws Exception {
		if (customerID == null) {
			throw new IllegalArgumentException("Invalid customer ID");
		}
		
		Long locationID = this.getCustomerLocation(customerID);
		if (locationID == null) {
			throw new IllegalArgumentException("There's no location for this customer ID");
		}
		
		return this.repository.findOne(locationID);
	}

	/**
	 * Method to map one customer with one location.
	 * 
	 * @param customerID
	 * @return location ID
	 */
	private Long getCustomerLocation(Long customerID) {
		final Map<Long, Long> customerLocation = new HashMap<>();
		customerLocation.put(1L, 1L);
		customerLocation.put(2L, 2L);
		
		return customerLocation.get(customerID);
	}
	
}
