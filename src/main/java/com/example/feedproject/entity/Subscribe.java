package com.example.feedproject.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter // 클래스 내 모든 필드의 getter 메서드 자동 생성
@Setter
@Entity // db의 테이블과 매칭될 클래스 - 카멜케이스 이름을 언더스코어 네이밍으로 바꿔서 테이블 매칭
@Table(name = "subscribe")
@NoArgsConstructor // 기본 생성자 자동 추가
@AllArgsConstructor
@Builder
public class Subscribe {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI 적용됨
    private Long id;

    private String fromChannel; // fk

    private String toChannel; // fk

    private LocalDateTime createDate;

}
