package com.example.feedproject.controller;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping("/channel")
    public ResponseEntity<Channel> createChannel
            (@RequestParam String channelName) {
        Channel createdChannel = channelService.create(channelName);
        return ResponseEntity.ok(createdChannel);
    }

}
