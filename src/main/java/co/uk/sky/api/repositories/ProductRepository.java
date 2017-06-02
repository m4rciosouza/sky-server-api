/**
 * Repository interface to access the database for a product.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.uk.sky.api.entities.Location;
import co.uk.sky.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * Find and return a list of products given a location.
	 * Products without location are included in the returned list. 
	 * 
	 * @param location
	 * @return products list
	 */
	@Query("SELECT p FROM Product p WHERE p.location IS NULL OR p.location = :location")
    List<Product> findByLocation(@Param("location") Location location);

}
