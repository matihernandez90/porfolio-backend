package com.carbonesoftware.portfolio.services.impl;

import com.carbonesoftware.portfolio.dto.LoginDTO;
import com.carbonesoftware.portfolio.entity.Configuration;
import com.carbonesoftware.portfolio.entity.User;
import com.carbonesoftware.portfolio.repository.AuthRepository;
import com.carbonesoftware.portfolio.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepo;

    @Override
    public Optional<User> login(LoginDTO credentials) {
        Optional<User> user = authRepo.findByEmail(credentials.getEmail());

        if(user.isPresent() && Objects.equals(user.get().getPassword(), credentials.getPassword())){

            return user;

        }else {

            return Optional.empty();

        }
    }

    @Override
    public void verifyToken(String token) {

    }

    @Override
    public Configuration save(Configuration data) {
        return null;
    }

}
