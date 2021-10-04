package com.example.feedproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final ContentsRepository contentsRepository;



    /**
     * 1. 사용자가 구독한 채널 조회
     * 2. 해당 채널에서 발행한 컨텐츠 조회
     * 3. 컨텐츠들 모두 Aggregation, 정렬
     * 4. 20개씩 페이징 리턴
     * getfeeds(100, 5)
     * content > channelA(content1)
     * subscribe > jihoYang, channelA
     * getFeed > jihoYang
     *
     */
    public void getFeeds(String user, int page, int size) {
        /**
         * contenst
         * id, channelName, contents
         * 기준 : id, createDate
         * 10개 채널 구독, 10씩 컨텐츠 생성 -> 100개
         * list, sort(id)
         * limit(20)
         */
        List<Channel> channelList = getSubscribedChannel(user);
        List<Contents> mergeList = new ArrayList<>();
        for(Channel channel : channelList) {
            List<Contents> contentsList = getContentsByChannel(String channel, Long id, int size);
            mergeList.add(contentsList);
        }
        // mergeList  sort
        // mregeList limit
        // return
    }

    /**
     * - 100
     * - 99
     * - 98
     * - 97
     * - 96
     * - ?
     */
    public void getFeeds(Long id, int size) {

    }
}
