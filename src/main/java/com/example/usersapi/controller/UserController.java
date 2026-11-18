package com.example.usersapi.controller;

import com.example.usersapi.dao.UserDAO;
import com.example.usersapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws SQLException {
        return userDAO.findAllUsers();
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<Map<String, String>> handleDatabaseException(Exception exception) {
        Map<String, String> error = Map.of(
                "error", "Database error",
                "message", "Unable to retrieve users. Please try again later."
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
