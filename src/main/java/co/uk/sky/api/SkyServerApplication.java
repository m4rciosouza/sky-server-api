/**
 * Spring boot application class, resposable to setup and start the application.
 * 
 * @author Marcio C. de Souza<m4rcio.souza@gmail.com>
 * @since 1.0.0
 */
package co.uk.sky.api;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.uk.sky.api.entities.Category;
import co.uk.sky.api.entities.Location;
import co.uk.sky.api.entities.Product;
import co.uk.sky.api.repositories.CategoryRepository;
import co.uk.sky.api.repositories.LocationRepository;
import co.uk.sky.api.repositories.ProductRepository;

@SpringBootApplication
public class SkyServerApplication {

	/**
	 * Run the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SkyServerApplication.class, args);
	}

	/**
	 * Utility method used to populate the basic data to the H2 database,
	 * as well as print in the console some debug data information.
	 * 
	 * @param categoryRepository
	 * @param productRepository
	 * @param locationRepository
	 * @return args
	 */
	@Bean
	public CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
			ProductRepository productRepository, LocationRepository locationRepository) {
		return args -> {
			// create the locations
			Location locLondon = locationRepository.save(new Location("LONDON"));
			Location locLiverpool = locationRepository.save(new Location("LIVERPOOL"));
			
			// create the categories
			Category catSports = categoryRepository.save(new Category("Sports"));
			Category catNews = categoryRepository.save(new Category("News"));
			
			// create the products
			productRepository.save(new Product("Arsenal TV", catSports, locLondon));
			productRepository.save(new Product("Chelsea TV", catSports, locLondon));
			productRepository.save(new Product("Liverpool TV", catSports, locLiverpool));
			productRepository.save(new Product("Sky News", catNews, null));
			productRepository.save(new Product("Sky Sports News", catNews, null));
			
			// list all products
			System.out.println("### All products");
			List<Product> products = productRepository.findAll();
			products.forEach(System.out::println);
			
			// list all products by London Location
			System.out.println("### London products");
			List<Product> londonProducts = productRepository.findByLocation(locLondon);
			londonProducts.forEach(System.out::println);
			
			// list all products by Liverpool Location
			System.out.println("### Liverpool products");
			List<Product> liverpoolProducts = productRepository.findByLocation(locLiverpool);
			liverpoolProducts.forEach(System.out::println);
		};
	}
	
}
