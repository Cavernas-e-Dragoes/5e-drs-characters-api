package com.ced.security;

import com.ced.data.DetailsUserDate;
import com.ced.model.user.User;
import com.ced.repository.UserRepository;
import com.ced.utils.helper.JwtHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    public JWTAuthFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper()
                    .readValue(request.getInputStream(), User.class);


            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new AuthenticationServiceException("Falha ao autenticar usuario", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {

        final DetailsUserDate detailsUserDate = (DetailsUserDate) authResult.getPrincipal();
        final String token = JwtHelper.generateToken(detailsUserDate.getUsername());

        Optional<User> authenticatedUser = userRepository.findByEmail(detailsUserDate.getUsername());
        if (authenticatedUser.isPresent()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("token", token);
            responseBody.put("user", authenticatedUser.get());

            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
            response.getWriter().flush();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\": \"Usuário não encontrado\"}");
            response.getWriter().flush();
        }
    }
}
