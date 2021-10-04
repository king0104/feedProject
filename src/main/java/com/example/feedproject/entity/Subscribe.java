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
@Table(name = "subscribe")
@Builder
public class Subscribe {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI 적용됨
    private Long id;

    private Channel fromChannel; // fk

    private Channel toChannel; // fk

    private LocalDateTime createDate;

    public Subscribe(Long id, Channel fromChannel, Channel toChannel, LocalDateTime createDate) {
        this.id = id;
        this.fromChannel = fromChannel;
        this.toChannel = toChannel;
        this.createDate = createDate;
    }
}
