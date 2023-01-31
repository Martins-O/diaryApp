package com.example.diary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiaryResponse {
    private String message;
    private Long id;

    public DiaryResponse(String message, Long id) {
        this.message = message;
        this.id = id;
    }
}
