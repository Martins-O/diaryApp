package com.example.diary.controller;

import com.example.diary.dto.request.CreateUserRequest;
import com.example.diary.dto.request.DeleteUserRequest;
import com.example.diary.dto.request.LoginRequest;
import com.example.diary.dto.request.UpdateUserRequest;
import com.example.diary.dto.response.DiaryResponse;
import com.example.diary.dto.response.LoginResponse;
import com.example.diary.dto.response.UpdateUserResponse;
import com.example.diary.exception.PasswordMisMatchException;
import com.example.diary.exception.UserException;
import com.example.diary.exception.UserNotFoundException;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class Controller {
//@Qualifier("userService")
    @Autowired
    private UserService diaryService;




    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        try{
            DiaryResponse resource = diaryService.createUser(request);
            return ResponseEntity.ok(resource);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        try{
            LoginResponse resource = diaryService.login(request);
            return ResponseEntity.ok(resource);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest request){
        try{
            UpdateUserResponse resource = diaryService.updateUser(request);
            return ResponseEntity.ok(resource);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<?> deleteUser(DeleteUserRequest request){
        try {
            var response = diaryService.deleteUser(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (PasswordMisMatchException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(diaryService.getRepo());
    }
}

