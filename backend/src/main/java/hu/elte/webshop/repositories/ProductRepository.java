package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByProductId(Long id);
    Iterable<Product> findAll();
}
