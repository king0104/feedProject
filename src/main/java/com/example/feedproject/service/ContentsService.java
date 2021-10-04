package com.example.feedproject.service;

import com.example.feedproject.dto.ContentsCreateRequestDto;
import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ContentsService {
    private final ContentsRepository contentsRepository;

    public Long create(Channel channel, String contents) {

        // 1. dto 객체 만들기
        ContentsCreateRequestDto requestDto = new ContentsCreateRequestDto();

        // 2. dto에 값 넣어주기
        requestDto.setChannel(channel);
        requestDto.setLikeCount(1); // 이거 설정하는 법 모름
        requestDto.setCreateDate(LocalDateTime.now());
        requestDto.setUpdateDate(LocalDateTime.now());
        requestDto.setContent(contents);

        return contentsRepository.save(requestDto.toEntity()).getId(); // save에는 객체를 넣어야 한다.
    }
}
