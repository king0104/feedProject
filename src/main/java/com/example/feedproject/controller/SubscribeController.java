package com.example.feedproject.controller;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeService subscribeService;

    // 구독 생성
    @PostMapping("subscribe")
    public void create(@RequestBody Channel fromChanel,
                       @RequestBody Channel toChannel) {

        subscribeService.create(fromChanel, toChannel);
    }

//    // 구독 조회
//    @GetMapping("subscribe/read")
//    public Subscribe read(@RequestParam String channelName) {
//
//        subscribeService.read(channelName);
//    }
}
