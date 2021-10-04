package com.example.feedproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedproject.service.SubscribeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeService subscribeService;

    // 구독 생성
    @PostMapping("subscribe")
    public void create(@RequestParam String fromChanel, @RequestParam String toChannel) {

        subscribeService.create(fromChanel, toChannel);
    }

//    // 구독 조회
//    @GetMapping("subscribe/read")
//    public Subscribe read(@RequestParam String channelName) {
//
//        subscribeService.read(channelName);
//    }
}
