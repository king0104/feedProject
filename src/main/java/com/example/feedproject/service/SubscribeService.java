package com.example.feedproject.service;

import org.springframework.stereotype.Service;

import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    public void create(String fromChannel, String toChannel) {

        Subscribe subscribe = Subscribe.builder()
            .fromChannel(fromChannel)
            .toChannel(toChannel)
            .build();

        subscribeRepository.save(subscribe);
    }

//    // 입력 받은 channel이 구독한 채널들을 조회하는 것
//    public Subscribe read(String fromChannel) {
//
//        Long id = fromChannel.getId();
//
//        return subscribeRepository.getById(id);
//    }
}
