package de.tk.mastermind.controller;

import de.tk.mastermind.models.LoginData;
import de.tk.mastermind.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public String login(@RequestBody LoginData loginData) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginData.getPlayername(), loginData.getPassword()));
            Map<String, Object> claims = new HashMap<>();

            return jwtService.createToken(claims, loginData.getPlayername());
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ungültige Registrierungsdaten");
        }
    }
}