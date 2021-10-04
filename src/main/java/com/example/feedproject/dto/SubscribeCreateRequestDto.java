package com.example.feedproject.dto;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Subscribe;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SubscribeCreateRequestDto {

    private Channel fromChannel;

    private Channel toChannel;

    private LocalDateTime createDate;

    @Builder
    public SubscribeCreateRequestDto(Channel fromChannel, Channel toChannel, LocalDateTime createDate) {
        this.fromChannel = fromChannel;
        this.toChannel = toChannel;
        this.createDate = createDate;
    }

    @Builder
    public Subscribe toEntity() {
        return Subscribe.builder()
                .fromChannel(fromChannel)
                .toChannel(toChannel)
                .createDate(createDate)
                .build();
    }
}
