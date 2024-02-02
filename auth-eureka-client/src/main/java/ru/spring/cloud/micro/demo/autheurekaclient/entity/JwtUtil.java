package ru.spring.cloud.micro.demo.autheurekaclient.entity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Collection;


@Data
@Component
public class JwtUtil {

    private static SecretKey secretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    public String generateToken(User user) throws Exception {
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("role", user.getRoles())
                .signWith(secretKey())
                .compact();
    }

    public User validateToken(String token) throws Exception {
        Claims claims = Jwts.parser().verifyWith(secretKey()).build()
                .parseSignedClaims(token).getPayload();

        User user = new User();
        user.setEmail(claims.getSubject());
        user.setRoles(claims.get("roles", Collection.class));

        return user;
    }


}
