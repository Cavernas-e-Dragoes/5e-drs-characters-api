package com.ced.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ced.config.SecurityProperties;
import com.ced.exception.InvalidTokenException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtHelper {

    private final SecurityProperties securityProperties;

    public JwtHelper(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public static String decodeToken(String token) {
        try {
            token = token.replaceAll("Bearer\\s+", "");
            DecodedJWT decodedJwt = JWT.decode(token);
            if (decodedJwt.getExpiresAt().before(new Date())) {
                return null;
            }
            Claim sub = decodedJwt.getClaim("sub");
            return sub == null ? null : sub.asString();
        } catch (Exception e) {
            throw new InvalidTokenException("Token inválido ou não fornecido.");
        }
    }

    public String generateToken(final String subject) {
        Algorithm algorithm = Algorithm.HMAC512(securityProperties.getToken());
        return JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + securityProperties.getExpiration()))
                .sign(algorithm);
    }
}
