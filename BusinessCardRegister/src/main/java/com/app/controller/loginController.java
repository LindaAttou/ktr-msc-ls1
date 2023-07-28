package com.app.controller;

import com.app.model.User;
import com.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class loginController {

    @Autowired
    private UserRepo repo ;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userlog){
        System.out.println(userlog);
        User user=repo.findByEmail(userlog.getEmail());
        if (user.getPassword().equals(userlog.getPassword()))
            return ResponseEntity.ok(user);
        return  (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
