package com.example.feedproject.service;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;

    public Contents create(String channelName, String contents) {
        Contents content1 = Contents.builder()
            .channelName(channelName)
            .content(contents)
            .createDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .likeCount(0)
            .build();

        return contentsRepository.save(content1); // save에는 객체를 넣어야 한다.
    }
}
