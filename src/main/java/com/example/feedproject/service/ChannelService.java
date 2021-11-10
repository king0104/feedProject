package com.example.feedproject.service;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;

    public Channel create(String name) {
        Channel channel = Channel.builder()
                .name(name)
                .followerCount(0)
                .createDate(LocalDateTime.now())
                .build();

        return channelRepository.save(channel);
    }

}
