package com.tweteroo.api.Controller;

import java.util.List;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Models.TweetModels;
import com.tweteroo.api.Service.TweetsServices;
import com.tweteroo.api.dto.TweetsDTO;

@RestController
@RequestMapping("/tweet")
public class Tweet {

    @Autowired
    private TweetsServices Tweetservice;

    @GetMapping
    public Page<TweetModels> getTweets(@RequestParam String page) {
        int pageNumber = Integer.parseInt(page);
        Pageable sortedByIdDesc = PageRequest.of(pageNumber, 5, Sort.by("id").descending());
        return Tweetservice.getTweets(sortedByIdDesc);
    }

    @GetMapping("/{username}")
    public List<TweetModels> getTweetsByUser(@PathVariable String username) {
        return Tweetservice.getTweetsByUser(username);
    }

    @PostMapping
    public void createTweet(@RequestBody TweetsDTO req) {
        Tweetservice.createTweet(req);
        ResponseEntity.ok().build();
    }

}