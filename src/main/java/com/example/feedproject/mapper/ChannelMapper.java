package com.example.feedproject.mapper;

import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    //@Mapping
    ChannelDto toChannelDto(Channel channel);
}

