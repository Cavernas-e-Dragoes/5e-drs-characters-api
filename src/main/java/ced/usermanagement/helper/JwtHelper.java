package ced.usermanagement.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtHelper {

    private JwtHelper() {
    }
    public static String findUser(String token) {
        token = token.replaceAll("Bearer\\s+", "");
        DecodedJWT decodedJwt = JWT.decode(token);

        Claim sub = decodedJwt.getClaim("sub");
        return sub == null ? null : sub.asString();
    }
}
