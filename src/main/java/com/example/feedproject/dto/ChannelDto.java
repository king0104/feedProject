package com.example.feedproject.dto;

import com.example.feedproject.entity.Channel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {
    private Long id;

    private String name;

    private int followerCount;

    private LocalDateTime createDate;

    public ChannelDto(Channel channel) {
        this.id = channel.getId();
        this.name = channel.getName();
        this.followerCount = channel.getFollowerCount();
        this.createDate = channel.getCreateDate();
    }
}
