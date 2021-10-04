package com.example.feedproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.service.ContentsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ContentsController {

    private final ContentsService contentsService;

    // 2. uri 상에서 데이터 받기
    @PostMapping("/contents")
    public ResponseEntity<Contents> createContent(@RequestParam String channelName, @RequestBody String contents) {
        Contents createdContent = contentsService.create(channelName, contents);
        return ResponseEntity.ok(createdContent);
    }
}
