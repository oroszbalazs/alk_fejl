package hu.elte.webshop.controllers;

import hu.elte.webshop.entities.Basket;
import hu.elte.webshop.repositories.BasketRepository;
import hu.elte.webshop.security.*;
import hu.elte.webshop.entities.Role;
import hu.elte.webshop.entities.User;
import hu.elte.webshop.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;

import hu.elte.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByUserName(user.getUserName());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity login() {
        Basket basket = new Basket(userService.getActUser().getUserId(), userService.getActUser(), null);
        return ResponseEntity.ok(basketRepository.save(basket));
    }

    @GetMapping("/logoff")
    public ResponseEntity logoff() {
        Basket basket = basketRepository.findByUserUserId(authenticatedUser.getUser().getUserId());
        basketRepository.delete(basket);
        authenticatedUser.setUser(null);
        return ResponseEntity.ok(0);
    }
    
    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
}
