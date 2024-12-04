package com.ced.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ced.properties.SecurityProperties;
import com.ced.exception.InvalidTokenException;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.ced.constants.ApplicationConstants.BEARER_PREFIX;
import static com.ced.constants.ApplicationConstants.JWT_SUBJECT_CLAIM;

@Component
public class JWTHelper {

    private final SecurityProperties securityProperties;

    public JWTHelper(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public static String decodeToken(String token) {
        try {
            token = token.replaceAll(BEARER_PREFIX, "");
            DecodedJWT decodedJwt = JWT.decode(token);
            if (decodedJwt.getExpiresAt().before(new Date())) {
                return null;
            }
            Claim sub = decodedJwt.getClaim(JWT_SUBJECT_CLAIM);
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
