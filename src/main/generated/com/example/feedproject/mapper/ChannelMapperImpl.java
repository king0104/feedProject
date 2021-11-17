package com.example.feedproject.mapper;

import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.entity.Channel;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T22:10:09+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (ojdkbuild)"
)
@Component
public class ChannelMapperImpl implements ChannelMapper {

    @Override
    public ChannelDto toChannelDto(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setId( channel.getId() );
        channelDto.setName( channel.getName() );
        channelDto.setFollowerCount( channel.getFollowerCount() );
        channelDto.setCreateDate( channel.getCreateDate() );

        return channelDto;
    }
}
