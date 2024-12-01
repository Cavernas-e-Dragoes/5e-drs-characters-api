package com.ced.security;

import com.ced.data.DetailsUserDate;
import com.ced.model.User;
import com.ced.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.ced.constants.ApplicationConstants.CONTENT_TYPE_JSON;
import static com.ced.constants.ApplicationConstants.TOKEN_IDENTIFIER;
import static com.ced.constants.ApplicationConstants.USER_IDENTIFIER;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtHelper jwtHelper;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public JWTAuthFilter(AuthenticationManager authenticationManager, UserRepository userRepository, JwtHelper jwtHelper) {
        super(authenticationManager);
        this.userRepository = userRepository;
        this.jwtHelper = jwtHelper;
        this.authenticationManager = authenticationManager;
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
            throw new AuthenticationServiceException("Fail!", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {

        final DetailsUserDate detailsUserDate = (DetailsUserDate) authResult.getPrincipal();
        final String token = jwtHelper.generateToken(detailsUserDate.getUsername());

        Optional<User> authenticatedUser = userRepository.findByEmail(detailsUserDate.getUsername());
        if (authenticatedUser.isPresent()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put(TOKEN_IDENTIFIER, token);
            responseBody.put(USER_IDENTIFIER, authenticatedUser.get());

            response.setContentType(CONTENT_TYPE_JSON);
            response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
            response.getWriter().flush();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\": \"User Not Found\"}");
            response.getWriter().flush();
        }
    }
}
