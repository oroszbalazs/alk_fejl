package hu.elte.webshop.controllers;

import hu.elte.webshop.entities.Basket;
import hu.elte.webshop.entities.Order;
import hu.elte.webshop.entities.Product;
import hu.elte.webshop.entities.Status;
import hu.elte.webshop.repositories.BasketRepository;
import hu.elte.webshop.repositories.OrderRepository;
import hu.elte.webshop.repositories.ProductRepository;
import hu.elte.webshop.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuthenticatedUser actUser;

    @PostMapping("/order")
    public ResponseEntity order() {
        Order ord = new Order();
        ord.setStatus(Status.STATUS_NEW);
        ord.setUser(actUser.getUser());
        ord.setProduct(actUser.getUser().getBasket().getProduct());

        if (ord.getUser() == null || ord.getProduct() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(orderRepository.save(ord));
    }

    @GetMapping("/orders")
    public ResponseEntity orders() {
        Iterable<Order> ods = orderRepository.test();
        return ResponseEntity.ok(ods);
    }

}
