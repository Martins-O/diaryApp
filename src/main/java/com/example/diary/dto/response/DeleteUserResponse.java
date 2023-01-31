package com.example.diary.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DeleteUserResponse {
    private String message;


    public DeleteUserResponse(String message) {
        this.message = message;
    }

}
