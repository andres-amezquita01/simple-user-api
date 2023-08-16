package com.simpleapi.mysimpleapi.controller;

import com.simpleapi.mysimpleapi.domain.User;
import com.simpleapi.mysimpleapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/")
    public ResponseEntity<?>  saveStudent(@RequestBody User userToSave){
        User userFound = userService.findUserById(userToSave.getUserId());
        if (userFound != null) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "The user with id " + userToSave.getUserId() + " already exists!");
            problemDetail.setTitle("User already exists!");
            problemDetail.setDetail("The user with id " + userToSave.getUserId() + " already exists!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(problemDetail);
        }
        return new ResponseEntity<>(userService.saveUser(userToSave), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long userToRemoveId){
        User userFound = userService.findUserById(userToRemoveId);
        if (userFound == null) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "The user with id " + userToRemoveId + " does not exist!");
            problemDetail.setTitle("User not found");
            problemDetail.setDetail("The user with id " + userToRemoveId + " does not exist!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
        }
        userService.removeUser(userToRemoveId);
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long userToFind){
        User userFound = userService.findUserById(userToFind);
        if (userFound == null) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "The user with id " + userToFind + " does not exist!");
            problemDetail.setTitle("User not found");
            problemDetail.setDetail("The user with id " + userToFind + " does not exist!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
        }
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> changeUserState(@PathVariable("id") long userToChangeStateId){
        User userFound = userService.findUserById(userToChangeStateId);
        if (userFound == null) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "The user with id " + userToChangeStateId + " does not exist!");
            problemDetail.setTitle("User not found");
            problemDetail.setDetail("The user with id " + userToChangeStateId + " does not exist!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userToChangeStateId);
        }
        boolean userState = userService.updateUserState(userFound);
        return new ResponseEntity<>(userState, HttpStatus.OK);
    }

}
