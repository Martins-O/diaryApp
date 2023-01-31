package com.example.diary.data.model;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "users")
//@Table(
//        name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "Users_Username_unique",
//                columnNames = "users.username")
//        }
//)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @SequenceGenerator(
            name = "Users_sequence",
            sequenceName = "Users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = ""
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "firstName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
     @Column(
            name = "lastName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
     @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
              unique = true
    )
    private String email;
    private String password;
    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;
    private String conPassword;
//
//    private final List<Entry> entries = new ArrayList<>();
}
