/**
 * Repository interface to access the database for a location.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.sky.api.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	
	/**
	 * Find and return one location by location's name.
	 * 
	 * @param name
	 * @return location
	 */
	Location findByName(String name);

}
