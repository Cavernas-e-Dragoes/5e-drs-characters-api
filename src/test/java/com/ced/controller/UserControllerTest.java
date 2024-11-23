package com.ced.controller;

import com.ced.dto.UserDTO;
import com.ced.model.User;
import com.ced.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class UserControllerTest {

    private final UserService userService = mock(UserService.class);
    private final UserController userController = new UserController(userService);


    @Test
    void shouldCreateUserAndReturnCreatedResponse() {
        // Arrange
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        UserDTO userDTO = new UserDTO("john.doe@example.com");

        Mockito.when(userService.userCreate(any(User.class))).thenReturn(userDTO);

        // Act
        ResponseEntity<UserDTO> response = userController.create(user);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Response status should be 201 CREATED");
        assertEquals(userDTO, response.getBody(), "Response body should match the expected UserDTO");
    }
}
