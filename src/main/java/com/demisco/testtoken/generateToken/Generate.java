package com.demisco.testtoken.generateToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class Generate {
    private final String secretKey="your seccret key";
    private final long expiration=3600;
    @GetMapping("/token")
    public String Generate(@RequestParam String username) {
        System.out.println("hi");
        System.out.println("tesr");
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }
}
