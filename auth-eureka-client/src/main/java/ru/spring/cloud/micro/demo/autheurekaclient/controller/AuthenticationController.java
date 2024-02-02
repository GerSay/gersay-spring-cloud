package ru.spring.cloud.micro.demo.autheurekaclient.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.spring.cloud.micro.demo.autheurekaclient.entity.User;
import ru.spring.cloud.micro.demo.autheurekaclient.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @PreAuthorize("isAnonymous()")
    public User signup(@RequestBody @Valid User user) {
        return authenticationService.registerUser(user);
    }

    @PostMapping("/sign-in")
    public String signin(@RequestParam String username, @RequestParam String password) throws Exception {
        return authenticationService.authenticateUser(username, password);
    }
}