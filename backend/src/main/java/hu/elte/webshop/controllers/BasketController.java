package hu.elte.webshop.controllers;

import hu.elte.webshop.entities.Basket;
import hu.elte.webshop.entities.Product;
import hu.elte.webshop.repositories.BasketRepository;
import hu.elte.webshop.repositories.ProductRepository;
import hu.elte.webshop.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthenticatedUser actUser;

    @GetMapping("/listall")
    public ResponseEntity<Iterable<Basket>> getAll() {
        return new ResponseEntity(basketRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addtobasket")
    public ResponseEntity<Basket> addToBasket(@RequestBody Product product) {

        Product actProduct = productRepository.findByProductId(product.getProductId());
        if (actProduct == null) {
            return ResponseEntity.badRequest().build();
        }

        Basket actBasket = basketRepository.findByUserUserId(actUser.getUser().getUserId());
        actBasket.getProduct().add(actProduct);

        return ResponseEntity.ok(basketRepository.save(actBasket));
    }

}
