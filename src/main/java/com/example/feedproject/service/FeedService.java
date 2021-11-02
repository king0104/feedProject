package com.example.feedproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.repository.ChannelRepository;
import com.example.feedproject.repository.SubscribeRepository;
import org.springframework.stereotype.Service;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final ContentsRepository contentsRepository;
    private final SubscribeRepository subscribeRepository;
    private final ChannelRepository channelRepository;

    /**
     * 1. 사용자가 구독한 채널 조회
     * 2. 해당 채널에서 발행한 컨텐츠 조회
     * 3. 컨텐츠들 모두 Aggregation, 정렬
     * 4. 20개씩 페이징 리턴
     * getfeeds(100, 5)
     * content > channelA(content1)
     * subscribe > jihoYang, channelA
     * getFeed > jihoYang
     */
    public List<Contents> getFeeds(String user) { //, int page, int size) {
        /**
         * contenst
         * id, channelName, contents
         * 기준 : id, createDate
         * 10개 채널 구독, 10씩 컨텐츠 생성 -> 100개
         * list, sort(id)
         * limit(20)
         */
        // 1. 사용자가 구독한 채널 조회
        List<Channel> channelList = getSubscribedChannel(user);
        List<Contents> mergeList = new ArrayList<>();
        // 2. 채널 하나씩 선택하기
        for (Channel channel : channelList) {
            // 3. 채널의 content 뽑아내기
            List<Contents> contentsList = getContentsByChannel(channel); // Long id, int size);
            for(Contents content : contentsList) {
                mergeList.add(content);
            }
        }
        return mergeList;
        // mergeList  sort
        // mregeList limit
        // return
    }

    public List<Channel> getSubscribedChannel(String name) {
        List<Subscribe> subscribedlList = subscribeRepository.findAll();
        List<Channel> subscribedChannelList = new ArrayList<>();

        for (Subscribe ss : subscribedlList) {
            if (ss.getFromChannel() == name) { // from을 찾고
                // to를 얻어서
                String tempName = ss.getToChannel();
                // to에 해당하는 channel 찾가
                Channel channel = getChannelByName(tempName);
                // 1. subscribe의 객체를 가지고, channel과 연결해주어야 한다

                // 2. channel 객체 하나 찾아서, 넣어주기
                subscribedChannelList.add(channel);

            }
        }

        return subscribedChannelList;
    }

    public Channel getChannelByName(String name) {
        List<Channel> channelList = channelRepository.findAll();

        for (Channel ch : channelList) {
            if (ch.getName() == name) {
                return ch;
            }
        }
        return null; // 이거 안쓰고 optional 쓰는 방법 알아보기

    }

    public List<Contents> getContentsByChannel(Channel channel) {
        String channelName = channel.getName();

        List<Contents> contentsList = contentsRepository.findAll();
        List<Contents> contentsListResult = new ArrayList<>();

        for(Contents content : contentsList) {
            if (content.getChannelName() == channelName) {
                contentsListResult.add(content);
            }
        }

        return contentsListResult;
    }



}
//    /**
//     * - 100
//     * - 99
//     * - 98
//     * - 97
//     * - 96
//     * - ?
//     */
//    public void getFeeds(Long id, int size) {
//
//    }

