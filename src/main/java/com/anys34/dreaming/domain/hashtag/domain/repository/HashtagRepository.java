package com.anys34.dreaming.domain.hashtag.domain.repository;

import com.anys34.dreaming.domain.hashtag.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
