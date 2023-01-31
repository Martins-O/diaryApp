package com.example.diary.data.repositories;

import com.example.diary.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findDiaryByUsername(String username);

}
