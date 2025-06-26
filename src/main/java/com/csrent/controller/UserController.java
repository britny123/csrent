package com.csrent.controller;

import com.csrent.dto.UserDTO;
import com.csrent.model.User;
import com.csrent.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if(result.hasErrors()){
            List<String> errores = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errores);
            //return ResponseEntity.ok("Hay algun error ");
        }
        //User createdUser = userService.createUser(new User());
        //return ResponseEntity.status(201).body(createdUser);
        return ResponseEntity.ok("Se registró el usuario");
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDTO user) {
        System.out.println(user.getEmail());
        User updatedUser = userService.getUserByEmail(user.getEmail());
        if (updatedUser != null) {
            updatedUser.setName(user.getName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRol(user.getRol());
            return ResponseEntity.ok(userService.updateUser(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping
    public ResponseEntity<User> partialUpdateUser(@RequestBody User user) {
        User updatedUser = userService.edit(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
