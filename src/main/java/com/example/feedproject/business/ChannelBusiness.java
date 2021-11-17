package com.example.feedproject.business;

import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.dto.ContentsDto;
import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ChannelRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChannelBusiness {

    private final ChannelRepository channelRepository;

//    public ChannelDto createChannelDto(String channelName) {
//        Channel channel = channelRepository.findChannelByName(channelName);
//        ChannelDto channelDto = new ChannelDto(channel);
//
//        return channelDto;
//    }

    public ChannelDto createChannelDto(Channel channel) {
        ChannelDto channelDto = new ChannelDto(channel);
        return channelDto;
    }

}


