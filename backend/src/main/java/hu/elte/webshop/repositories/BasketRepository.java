package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Basket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
    //@Query("SELECT * FROM basket b WHERE b.user_id = 'Id'")
    Basket findByUserUserId(Long Id);
}
