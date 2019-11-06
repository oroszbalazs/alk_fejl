package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
    Iterable<Basket> findByUserId(Long id);
}
