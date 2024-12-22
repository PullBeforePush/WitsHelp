package com.WitsHelp.WitsHelp.Controller;

import com.WitsHelp.WitsHelp.Entity.User;
import com.WitsHelp.WitsHelp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-error-message", "Something went wrong while creating the user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .build();
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable Long user_id) {
        try {
            Optional<User> optionalUser = userService.getUser(user_id);
            if(optionalUser.isPresent()){
                return ResponseEntity.ok(optionalUser.get());
            } else {
                // If user is not found, return 404 with custom header
                HttpHeaders headers = new HttpHeaders();
                headers.add("x-error-message", "User not found with id: " + user_id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .headers(headers)
                        .build();
            }
        }catch (Exception e) {
            // Catch any other unforeseen exceptions and return 500
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-error-message", "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .headers(headers)
                    .build();
        }
    }
}
