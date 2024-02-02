package ru.spring.cloud.micro.demo.autheurekaclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.spring.cloud.micro.demo.autheurekaclient.entity.JwtUtil;
import ru.spring.cloud.micro.demo.autheurekaclient.entity.User;
import ru.spring.cloud.micro.demo.autheurekaclient.repository.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String authenticateUser(String username, String password) throws Exception {
        User user = userRepository.findByEmail(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user);
        }
        return null;
    }
}