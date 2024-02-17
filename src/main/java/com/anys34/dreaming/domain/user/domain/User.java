package com.anys34.dreaming.domain.user.domain;

import com.anys34.dreaming.domain.hashtag.domain.Hashtag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String goal;

    private Boolean admin;

    private String week;

    private String month;

    private String year;

    @ManyToMany
    @JoinTable(
            name = "user_hashtag",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private List<Hashtag> hashtags;

    @Builder
    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.profileImg = "https://url.kr/njphmd";
        this.admin = false;
    }

    public void updateHashTags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public void updateGoal(String goal) {
        this.goal = goal;
    }

    public void updateWeek(String week) {
        this.week = week;
    }

    public void updateMonth(String month) {
        this.month = month;
    }

    public void updateYear(String year) {
        this.year = year;
    }

    public void updateImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
