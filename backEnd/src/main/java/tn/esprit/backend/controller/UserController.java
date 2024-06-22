package tn.esprit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.model.classes.User;
import tn.esprit.backend.service.ServiceImpl.UserServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal) {
        if (principal == null) {
            // Handle case where user is not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = userService.findUserByUsername(principal.getName());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profileUpdate")
    public ResponseEntity<?> updateUserProfile(@RequestBody User user, Principal principal) {
        userService.updateUserProfile(principal.getName(), user);
        return ResponseEntity.ok("Profile updated successfully");
    }


}
