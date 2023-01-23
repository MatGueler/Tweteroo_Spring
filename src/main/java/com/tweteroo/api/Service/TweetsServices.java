package com.tweteroo.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.Models.TweetModels;
import com.tweteroo.api.Models.UserModels;
import com.tweteroo.api.Repository.TweetsRepository;
import com.tweteroo.api.Repository.UserRepository;
import com.tweteroo.api.dto.TweetsDTO;

@Service
public class TweetsServices {

    @Autowired
    private TweetsRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<TweetModels> getTweets(Pageable pageable) {
        return tweetRepository.findAllByOrderByIdDesc(pageable);
    }

    public List<TweetModels> getTweetsByUser(String username) {

        Optional<UserModels> user = userRepository.findUserByUsername(username);

        if (!user.isPresent()) {
            return List.of();
        }
        return (tweetRepository.findByUsername(username));
    }

    public void createTweet(TweetsDTO req) {

        Optional<UserModels> user = userRepository.findUserByUsername(req.username());

        if (user.isPresent()) {
            tweetRepository.save(new TweetModels(req, user.get().getAvatar()));
        }

    }

}
