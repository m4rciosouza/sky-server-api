/**
 * Repository interface to access the database for a category.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.sky.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
