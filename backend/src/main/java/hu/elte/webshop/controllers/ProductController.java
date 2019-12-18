package hu.elte.webshop.controllers;

import hu.elte.webshop.entities.Product;
import hu.elte.webshop.security.*;
import hu.elte.webshop.entities.Role;
import hu.elte.webshop.entities.User;
import hu.elte.webshop.repositories.ProductRepository;
import hu.elte.webshop.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
        public ResponseEntity<Iterable<Product>> getAll() {
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }
}
