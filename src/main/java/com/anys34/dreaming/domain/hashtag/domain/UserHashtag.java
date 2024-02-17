package com.anys34.dreaming.domain.hashtag.domain;

import com.anys34.dreaming.domain.user.domain.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_hashtag")
public class UserHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
}
