/**
 * Service interface for catalogue.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.services.interfaces;

import java.util.List;

import co.uk.sky.api.entities.Product;

public interface CatalogueService {

	/**
	 * Gets and return the catalogue (list of products) given a location ID.
	 * 
	 * @param location
	 * @return list of products
	 * @throws Exception
	 */
	List<Product> getCatalogue(String location) throws Exception;
	
}
