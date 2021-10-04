package com.example.feedproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // 클래스 내 모든 필드의 getter 메서드 자동 생성
@Setter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // db의 테이블과 매칭될 클래스 - 카멜케이스 이름을 언더스코어 네이밍으로 바꿔서 테이블 매칭
@Table(name = "channel")
@Builder
public class Channel {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI 적용됨
    private Long id;

    private String name;

    private String followerCount;

    private String createDate;

    @OneToMany(mappedBy = "channel")
    List<Contents> contents = new ArrayList<>();

    @OneToMany(mappedBy = "fromChannel") // 질문 : mapped by에 들어가는 값은 뭔지 모르겠습니다
    // 내 생각 : @ManyToOne으로 설정한 필드 명을 적어주면 된다,
    List<Subscribe> fromSubscribes = new ArrayList<>();

    @OneToMany(mappedBy = "toChannel")
    List<Subscribe> toSubscribes = new ArrayList<>();


    public Channel(Long id, String name, String followerCount, String createDate) {

        this.id = id;
        this.name = name;
        this.followerCount = followerCount;
        this.createDate = createDate;
    }
}
