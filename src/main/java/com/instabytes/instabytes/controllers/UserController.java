package com.instabytes.instabytes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instabytes.instabytes.dto.UserDTO;
import com.instabytes.instabytes.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        UserDTO newUser = userService.create(dto);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO dto = userService.findById(id);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok(list);
    }
}
