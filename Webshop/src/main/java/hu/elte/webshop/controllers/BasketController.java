package hu.elte.webshop.controllers;

import hu.elte.webshop.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("basket")
public class BasketController {
    @Autowired
    private BasketRepository basketRepository;

}
