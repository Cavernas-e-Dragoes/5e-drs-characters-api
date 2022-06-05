package ced.characters.management.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtHelper {

    private JwtHelper() {
    }
    public static String findUser(String token) {
        token = token.replaceAll("Bearer\\s+", "");
        DecodedJWT decodedJwt = JWT.decode(token);

        if(decodedJwt.getExpiresAt().before(new Date())) {
            return  "";
        }
        Claim sub = decodedJwt.getClaim("sub");
        return sub == null ? null : sub.asString();
    }
}
