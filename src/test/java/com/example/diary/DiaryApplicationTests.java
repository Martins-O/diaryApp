package com.example.diary;

import com.example.diary.data.model.User;
import com.example.diary.data.repositories.UserRepo;
import com.example.diary.dto.request.CreateUserRequest;
import com.example.diary.exception.PasswordMisMatchException;
import com.example.diary.service.UserService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DiaryApplicationTests {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepo repository;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void createUserTest() throws PasswordMisMatchException {
//       CreateUserRequest user = new CreateUserRequest();
//       user.setFirstName("Martins");
//       user.setLastName("Jones");
//       user.setEmail("Martins@example.com");
//       user.setPassword("123456");
//       user.setPasswordConfirmation("123456");
//       CreateUserRequest saved = repository.save(user);
//       service.createUser(saved);
//       assertEquals(1L, repository.count());
//    }

}
