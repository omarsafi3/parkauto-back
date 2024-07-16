package org.example.parkautoback.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.parkautoback.entity.User;

public class JwtTokenGenerator {
    private static final String SECRET_KEY = "G$eJ#8dLpR5tYkMnBvF4cA";

    public static String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}