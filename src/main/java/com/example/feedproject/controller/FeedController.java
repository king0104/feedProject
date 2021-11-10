package com.example.feedproject.controller;

import com.example.feedproject.dto.ContentsDto;
import com.example.feedproject.entity.Contents;
import com.example.feedproject.service.FeedService;
import io.swagger.annotations.ApiOperation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "get", description = "유저의 피드를 get하는 api입니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/feed")
    public ResponseEntity<List<ContentsDto>> getFeed(@RequestParam String channelName) {
        List<ContentsDto> contentsList = feedService.getFeeds(channelName);

        return ResponseEntity.ok(contentsList);

//        for(Contents ct : contentsList) {
//            System.out.println(ct);
//        }
    }
}
