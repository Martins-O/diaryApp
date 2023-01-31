package com.example.diary.dto.request;

import lombok.Getter;

@Getter
public class DeleteUserRequest {
    private String userName;
    private String password;
}
