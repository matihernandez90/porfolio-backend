package com.carbonesoftware.portfolio.controller;

import com.carbonesoftware.portfolio.dto.JwtResponse;
import com.carbonesoftware.portfolio.dto.LoginDTO;
import com.carbonesoftware.portfolio.services.JwtUserDetailsService;
import com.carbonesoftware.portfolio.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/auth")
@RestController
@CrossOrigin("*")
public class AuthController {

//    @Autowired
//    private AuthService authSvc;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginDTO data) {
//
//        Optional<User> userOpt = authSvc.login(data);
//
//
//
//        if (userOpt.isPresent()) {
//            return ResponseEntity.ok(userOpt.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginDTO authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
