package com.example.feedproject.service;

import java.util.*;
import java.util.stream.Collectors;

import com.example.feedproject.business.ChannelBusiness;
import com.example.feedproject.business.ContentsBusiness;
import com.example.feedproject.business.SubscribeBusiness;
import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.dto.ContentsDto;
import com.example.feedproject.dto.SubscribeDto;
import com.example.feedproject.entity.Channel;
import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.mapper.ChannelMapper;
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

    private final SubscribeBusiness subscribeBusiness;
    private final ContentsBusiness contentsBusiness;
    private final ChannelBusiness channelBusiness;

    private final ChannelMapper channelMapper;


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
    public List<ContentsDto> getFeeds(String user) { //, int page, int size) {
        /**
         * contenst
         * id, channelName, contents
         * 기준 : id, createDate
         * 10개 채널 구독, 10씩 컨텐츠 생성 -> 100개
         * list, sort(id)
         * limit(20)
         */
        // 1. 사용자가 구독한 채널 조회
        List<ChannelDto> channelDtoList = getSubscribedChannel(user);
        List<ContentsDto> mergeList = new ArrayList<>();
        // 2. 채널 하나씩 선택하기
        for (ChannelDto channelDto : channelDtoList) {
            // 3. 채널의 content 뽑아내기
            List<ContentsDto> contentsDtoListList = getContentsByChannel(channelDto); // Long id, int size);
            // 4. mergeList 만들기 (최종)
            for(ContentsDto content : contentsDtoListList) {
                mergeList.add(content);
            }
        }

        // 1. mergeList  sort
        Collections.sort(mergeList, new Comparator<ContentsDto>() {
            @Override
            public int compare(ContentsDto o1, ContentsDto o2) {
                if (o1.getCreateDate().isAfter(o2.getCreateDate())) {
                    return -1; // 안바꾸기
                }
                else if (o1.getCreateDate().isBefore(o2.getCreateDate())) {
                    return 1; // 바꾸기
                }
                else {
                    return 0;
                }
            }
        });

        // 2.limit mergeList
        return mergeList.subList(0,3);

    }

    // 사용자(파라미터)가 구독하는 모든 채널을 return하는 메서드
    public List<ChannelDto> getSubscribedChannel(String name) {

        // 1. repository에서 엔티티 가져옴
        List<Subscribe> subscribeList = subscribeRepository.findSubscribeByFromChannel(name);
        // 2. dto로 변환
        List<SubscribeDto> subscribedDtolList = subscribeBusiness.createSubscribedDtoList(subscribeList);

        List<ChannelDto> subscribedChannelList = new ArrayList<>();

        for (SubscribeDto subscribe : subscribedDtolList) {
            // to를 얻어서
            String toChannelName = subscribe.getToChannel();
            // to에 해당하는 channel 찾가
            ChannelDto channel = getChannelByName(toChannelName);

            // 1. subscribe의 객체를 가지고, channel과 연결해주어야 한다
            // 2. channel 객체 하나 찾아서, 넣어주기
            subscribedChannelList.add(channel);

        }

        return subscribedChannelList;
    }

    public ChannelDto getChannelByName(String name) {

        Channel channel = channelRepository.findChannelByName(name);
//        ChannelDto channelDto = channelMapper.INSTANCE.toChannelDto(channel);
        ChannelDto channelDto = channelBusiness.createChannelDto(channel);
        return channelDto;
        // 이거 안쓰고 optional 쓰는 방법 알아보기

    }

    public List<ContentsDto> getContentsByChannel(ChannelDto channel) {
        String channelName = channel.getName();

        List<Contents> contentsList = contentsRepository.findContentsByChannelName(channelName);
        List<ContentsDto> contentsDtoListList = contentsBusiness.createContentsDtoList(contentsList);

        return contentsDtoListList;
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

