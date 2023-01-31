package com.example.diary.dto.request;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
}
