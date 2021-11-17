package com.example.feedproject.mapper;

import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.entity.Channel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T18:32:59+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (ojdkbuild)"
)
public class ChannelMapperImpl implements ChannelMapper {

    @Override
    public ChannelDto toChannelDto(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        Channel channel1 = null;

        channel1 = channel;

        ChannelDto channelDto = new ChannelDto( channel1 );

        return channelDto;
    }
}
