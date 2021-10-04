package com.example.feedproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter // 클래스 내 모든 필드의 getter 메서드 자동 생성
@Setter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // db의 테이블과 매칭될 클래스 - 카멜케이스 이름을 언더스코어 네이밍으로 바꿔서 테이블 매칭
@Table(name = "contents")
@Builder
public class Contents {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI 적용됨
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="channel_name") // 이렇게 설정하는게 맞나? 어떻게 설정하는거지
    private Channel channel; // fk

    private int likeCount;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String content;

    @Builder
    public Contents(Long id, Channel channel, int likeCount, LocalDateTime createDate, LocalDateTime updateDate, String content) {
        this.id = id;
//        this.channelName = channelName;
        this.channel = channel;
        this.likeCount = likeCount;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.content = content;
    }

}
