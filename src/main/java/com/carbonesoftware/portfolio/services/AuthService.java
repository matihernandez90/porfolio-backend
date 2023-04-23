package com.carbonesoftware.portfolio.services;

import com.carbonesoftware.portfolio.dto.LoginDTO;
import com.carbonesoftware.portfolio.entity.Configuration;
import com.carbonesoftware.portfolio.entity.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> login(LoginDTO credentials);
    void verifyToken(String token);

    Configuration save(Configuration data);
}
