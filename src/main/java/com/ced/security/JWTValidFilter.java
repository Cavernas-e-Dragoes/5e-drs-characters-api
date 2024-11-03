package com.ced.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ced.utils.helper.JwtHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTValidFilter extends BasicAuthenticationFilter {

    public static final String HEADER_ATT = "Authorization";
    public static final String ATT_PREFIX = "Bearer ";

    public JWTValidFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String att = request.getHeader(HEADER_ATT);

        if (att == null || !att.startsWith(ATT_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        String token = att.replace(ATT_PREFIX, "");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

        String user = JWT.require(Algorithm.HMAC512(JwtHelper.TOKEN_PASSWORD))
                .build()
                .verify(token)
                .getSubject();

        if (user == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

    }

}
