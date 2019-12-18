package hu.elte.webshop.service;

import hu.elte.webshop.entities.User;
import hu.elte.webshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getActUser() throws UsernameNotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = ((UserDetails)principal).getUsername();
        Optional<User> oUser = userRepository.findByUserName(userName);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }
        User actUser = oUser.get();
        return actUser;
    }

}