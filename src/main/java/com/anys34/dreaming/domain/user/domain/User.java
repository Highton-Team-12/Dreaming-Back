package com.anys34.dreaming.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickname;

    private String password;

    @Column(name = "profile_img")
    private String profileImg;

    private Boolean admin;

    @Builder
    public User(String email, String nickname, String password, String profileImg) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.profileImg = profileImg;
        this.admin = false;
    }
}
