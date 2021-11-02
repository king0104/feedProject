package com.example.feedproject.controller;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping("/feed")
    public ResponseEntity<List<Contents>> printFeed(@RequestParam String channelName) {
        List<Contents> contentsList = feedService.getFeeds(channelName);

        return ResponseEntity.ok(contentsList);

//        for(Contents ct : contentsList) {
//            System.out.println(ct);
//        }
    }
}
