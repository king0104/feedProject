package com.example.feedproject.service;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;

    public Contents create(String channelName, String contents) {
        Contents contents1 = Contents.builder()
            .channelName(channelName)
            .content(contents)
            .build();

        return contentsRepository.save(contents1); // save에는 객체를 넣어야 한다.
    }
}
