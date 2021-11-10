package com.example.feedproject.dto;

import com.example.feedproject.entity.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeDto {
    private Long id;

    private String fromChannel; // fk

    private String toChannel; // fk

    private LocalDateTime createDate;

    public SubscribeDto(Subscribe subscribe) {
        this.id = subscribe.getId();
        this.fromChannel = subscribe.getFromChannel();
        this.toChannel = subscribe.getToChannel();
        this.createDate = subscribe.getCreateDate();
    }
}
