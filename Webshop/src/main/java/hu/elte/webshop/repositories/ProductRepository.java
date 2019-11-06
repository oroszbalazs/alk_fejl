package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
