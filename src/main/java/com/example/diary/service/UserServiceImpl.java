package com.example.diary.service;

import com.example.diary.data.model.User;
import com.example.diary.data.repositories.UserRepo;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("userService")
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
//@Autowired
    private UserRepo repo;

//    public UserServiceImpl(UserRepo repo) {
//        this.repo = repo;
//    }

    @Override
    public DiaryResponse createUser(CreateUserRequest request) throws PasswordMisMatchException {
            User newDiary = new User();
            newDiary.setFirstName(request.getFirstName());
            newDiary.setLastName(request.getLastName());
            newDiary.setUsername(request.getUsername());
            newDiary.setEmail(request.getEmail());
            newDiary.setPassword(request.getPassword());
            log.info("confirm->{}", request.getPassword());
            newDiary.setConPassword(request.getPasswordConfirmation());
            log.info("confirm->{}", request.getPasswordConfirmation());
            if (!request.getPassword().equals(request.getPasswordConfirmation())) {
                throw new PasswordMisMatchException("Password mismatch");
            }
            var savedGuy = repo.save(newDiary);
        return new DiaryResponse("Diary create successfully",savedGuy.getId());
    }


    @Override
    public LoginResponse login(LoginRequest request) throws UserNotFoundException {
         Optional<User> existingDiary = repo.findDiaryByUsername(request.getUsername());
        if (existingDiary.isEmpty()) {
            throw new UserNotFoundException("Please register or input correct username");
        }
        User loginDiary = existingDiary.get();
        loginDiary.setPassword(request.getPassword());
        repo.save(loginDiary);
        return new LoginResponse("Login successful");
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) throws UserNotFoundException {
        Optional<User> existingDiary = repo.findDiaryByUsername(request.getUsername());
        if (existingDiary.isEmpty()) {
            throw new UserNotFoundException("Please register or input correct username");
        }
        User updatedDiary = existingDiary.get();
        updatedDiary.setUsername(request.getUsername());
        updatedDiary.setEmail(request.getEmail());
        updatedDiary.setLastName(request.getLastname());
        return null;
    }

    @Override
    public Optional<User> findEntry(String id) {
        return repo.findById(id);
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) throws PasswordMisMatchException {
        User diary = new User();
        diary.setUsername(request.getUserName());
        diary.setPassword(request.getPassword());
        log.info("confirm->{}", request.getPassword());
        if (request.getPassword() == null){
            throw new PasswordMisMatchException("PassWord cannot be empty");
        }
        repo.delete(diary);

        return new DeleteUserResponse("Delete successfully");
    }
}
