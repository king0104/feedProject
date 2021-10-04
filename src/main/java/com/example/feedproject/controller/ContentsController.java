package com.example.feedproject.controller;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContentsController {

    private final ContentsService contentsService;

    @PostMapping("/contents")
    public Long create(@RequestBody Channel channel, // 컨텐츠가 존재하는 채널
                       // RequestBody를 이런 식으로 사용하는 것이 맞나요?
                       // 1. channel 객체 생성 -> json 데이터 받기

                       @RequestParam("ct") String contents) { // 2. uri 상에서 데이터 받기

        return contentsService.create(channel, contents);
    }
}
