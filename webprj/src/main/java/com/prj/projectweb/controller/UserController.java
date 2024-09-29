package com.prj.projectweb.controller;

import com.prj.projectweb.dto.ApiRequest;
import com.prj.projectweb.dto.ApiResponse;
import com.prj.projectweb.entities.User;
import com.prj.projectweb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> updatedUser = userService.updateUser(id, userDetails);
        return updatedUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // Đăng nhập API
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody ApiRequest request) {
        Optional<User> user = userService.findByEmail(request.getEmail());

        // Trường hợp email sai
        if (user.isEmpty())
            return new ResponseEntity<>(new ApiResponse(1001, "email wrong"), HttpStatus.BAD_REQUEST);

        if (!user.get().getPassword().equals(request.getPassword())) {
            // Trường hợp password sai
            return new ResponseEntity<>(new ApiResponse(1001, "password wrong"), HttpStatus.BAD_REQUEST);
        }

        // Đăng nhập thành công
        return new ResponseEntity<>(new ApiResponse(1000, "login successful"), HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String sayhello(){
        return "Hello";
    }
}


