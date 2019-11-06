package hu.elte.webshop.repositories;

import hu.elte.webshop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
