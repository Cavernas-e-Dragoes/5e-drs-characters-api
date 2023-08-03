package com.ced.utils.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ced.utils.exception.InvalidTokenException;

import java.util.Date;

public class JwtHelper {

    public static final String TOKEN_PASSWORD = System.getenv("TOKEN_PASSWORD");

    public static final int TOKEN_EXPIRATION_10MINUTES = 600_000;

    private JwtHelper() {
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
        } catch (JWTDecodeException e) {
            throw new InvalidTokenException("Token inválido ou não fornecido.");
        }
    }

    public static String generateToken(final String subject) {
        Algorithm algorithm = Algorithm.HMAC512(TOKEN_PASSWORD);
        return JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_10MINUTES))
                .sign(algorithm);
    }

}
