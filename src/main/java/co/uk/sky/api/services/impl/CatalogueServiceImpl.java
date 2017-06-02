/**
 * Catalogue service implementation.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.sky.api.entities.Location;
import co.uk.sky.api.entities.Product;
import co.uk.sky.api.repositories.LocationRepository;
import co.uk.sky.api.repositories.ProductRepository;
import co.uk.sky.api.services.interfaces.CatalogueService;

@Service
public class CatalogueServiceImpl implements CatalogueService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Product> getCatalogue(String locationName) throws Exception {
		if (locationName == null) {
			throw new IllegalArgumentException("Invalid location");
		} 
		
		Location location = this.locationRepository.findByName(locationName);
		if (location == null) {
			throw new IllegalArgumentException("There's no location for this location ID");
		} 
		 
		return this.productRepository.findByLocation(location);
	}

}
