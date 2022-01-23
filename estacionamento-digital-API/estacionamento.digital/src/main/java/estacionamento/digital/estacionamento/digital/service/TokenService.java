package service;

import estacionamento.digital.estacionamento.digital.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.security.Signature;
import java.util.Date;

@Service
public class TokenService {

    private String key = "String Aleatoria Secret";

    //30 minutos
    private static final long expirationTime = 1800000;

    public String generateToken(User user) {
        return OAuth2ResourceServerProperties.Jwt()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste JWT API")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims decodeToken(String token) {
        return OAuth2ResourceServerProperties.Jwt()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}