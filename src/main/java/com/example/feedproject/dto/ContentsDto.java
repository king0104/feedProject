package com.example.feedproject.dto;

import com.example.feedproject.entity.Contents;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ContentsDto {

    private Long id;

    private String channelName;

    private String content;

    private int likeCount;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public ContentsDto(Contents contents) {
        this.id = contents.getId();
        this.channelName = contents.getChannelName();
        this.content = contents.getContent();
        this.likeCount = contents.getLikeCount();
        this.createDate = contents.getCreateDate();
        this.updateDate = contents.getUpdateDate();
    }

}
