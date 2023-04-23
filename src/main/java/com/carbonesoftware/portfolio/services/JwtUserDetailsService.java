package com.carbonesoftware.portfolio.services;

import com.carbonesoftware.portfolio.entity.User;
import com.carbonesoftware.portfolio.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOpt = authRepo.findByEmail(email);

        if (userOpt.isPresent()) {
            return new org.springframework.security.core.userdetails.User(userOpt.get().getEmail(), userOpt.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

    }
}
