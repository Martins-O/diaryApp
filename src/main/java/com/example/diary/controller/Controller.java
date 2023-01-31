package com.example.diary.controller;

import com.example.diary.data.repositories.UserRepo;
import com.example.diary.dto.request.CreateUserRequest;
import com.example.diary.dto.request.DeleteUserRequest;
import com.example.diary.dto.response.DiaryResponse;
import com.example.diary.exception.PasswordMisMatchException;
import com.example.diary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class Controller {
//@Qualifier("userService")
    @Autowired
    private UserService diaryService;
    @Autowired
    private UserRepo repo;



    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        try{
            DiaryResponse resource = diaryService.createUser(request);
            return ResponseEntity.ok(resource);
        } catch (PasswordMisMatchException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
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
        return (ResponseEntity<?>) repo.findAll();
    }
}

