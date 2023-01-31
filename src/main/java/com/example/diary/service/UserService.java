package com.example.diary.service;

import com.example.diary.data.model.User;
import com.example.diary.dto.request.CreateUserRequest;
import com.example.diary.dto.request.DeleteUserRequest;
import com.example.diary.dto.request.LoginRequest;
import com.example.diary.dto.request.UpdateUserRequest;
import com.example.diary.dto.response.DeleteUserResponse;
import com.example.diary.dto.response.DiaryResponse;
import com.example.diary.dto.response.LoginResponse;
import com.example.diary.dto.response.UpdateUserResponse;
import com.example.diary.exception.PasswordMisMatchException;
import com.example.diary.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {

    DiaryResponse createUser(CreateUserRequest request) throws PasswordMisMatchException;
    LoginResponse login (LoginRequest request) throws UserNotFoundException;
    UpdateUserResponse updateUser (UpdateUserRequest request) throws UserNotFoundException;

    Optional<User> findEntry(String id);

    DeleteUserResponse deleteUser(DeleteUserRequest request) throws PasswordMisMatchException;

}
