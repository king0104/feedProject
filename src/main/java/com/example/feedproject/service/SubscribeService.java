package com.example.feedproject.service;

import com.example.feedproject.dto.SubscribeCreateRequestDto;
import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    public void create(Channel fromChannel, Channel toChannel) {

        // 1. dto 객체 생성
        SubscribeCreateRequestDto requestDto = new SubscribeCreateRequestDto();

        // 2. dto에 값 넣어주기
        requestDto.setFromChannel(fromChannel);
        requestDto.setToChannel(toChannel);
        requestDto.setCreateDate(LocalDateTime.now());

        subscribeRepository.save(requestDto.toEntity());
    }

//    // 입력 받은 channel이 구독한 채널들을 조회하는 것
//    public Subscribe read(String fromChannel) {
//
//        Long id = fromChannel.getId();
//
//        return subscribeRepository.getById(id);
//    }
}
