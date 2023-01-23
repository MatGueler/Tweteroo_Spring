package com.tweteroo.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Service.UsersService;
import com.tweteroo.api.dto.UserDTO;

@RestController
@RequestMapping("/sign-up")
public class Signup {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<String> Signup(@RequestBody UserDTO req) {
        usersService.createUser(req);
        return ResponseEntity.ok("ok");
    }

}
