package com.tweteroo.api.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.Models.TweetModels;

public interface TweetsRepository extends JpaRepository<TweetModels, Long> {

    List<TweetModels> findByUsername(String username);

    Page<TweetModels> findAllByOrderByIdDesc(Pageable pageabl);
}
