package com.example.feedproject.dto;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Contents;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * id 필드만 제외하고 나머지 필드 포함
 *
 * toEntity() 메서드 존재
 *  - dto에 해당하는 Entity 하나를 만들어서 리턴해주는 메서드
 */
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ContentsCreateRequestDto {
    private Channel channel;

    private int likeCount;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String content;

    @Builder
    public ContentsCreateRequestDto(Channel channel, int likeCount, LocalDateTime createDate, LocalDateTime updateDate, String content) {
        this.channel = channel;
        this.likeCount = likeCount;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.content = content;
    }

//     이건 어디에 쓰는 것일까..? 느낌이 엔티티 하나를 만들어서 리턴하는 것 같다
    @Builder
     public Contents toEntity() {
        return Contents.builder()
                .channel(channel)
                .likeCount(likeCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .content(content)
                .build();
    }

}
