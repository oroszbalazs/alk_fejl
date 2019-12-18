package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    //Iterable<Order> findById(Long id);
    @Query(value = "SELECT * FROM order_table NATURAL JOIN order_user", nativeQuery = true)
    Iterable<Order> test();
}
