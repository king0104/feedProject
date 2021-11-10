package com.example.feedproject.business;

import com.example.feedproject.dto.ContentsDto;
import com.example.feedproject.dto.SubscribeDto;
import com.example.feedproject.entity.Contents;
import com.example.feedproject.entity.Subscribe;
import com.example.feedproject.repository.SubscribeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * dto를 만드는 메서드 작성
 * 1. repository 가져오기
 * 2. 메서드 사용해서 entity 받기
 * 3. entity -> dto 변환
 */

/**
 * repository에서 받은 entity를 dto로 변환하는 레이어(?)
 */

@Service
@AllArgsConstructor
public class SubscribeBusiness {
    private final SubscribeRepository subscribeRepository;

//    public List<SubscribeDto> createSubscribeDto (String channelName) {
//        List<Subscribe> subscribeList = subscribeRepository.findSubscribeByFromChannel(channelName);
//        List<SubscribeDto> subscribeDtoList = new ArrayList<>();
//
//        for(Subscribe subscribe : subscribeList) {
//            subscribeDtoList.add(new SubscribeDto(subscribe));
//        }
//
//        return subscribeDtoList;
//    }

    public  List<SubscribeDto> createSubscribedDtoList (List<Subscribe> subscribedList) {
        List<SubscribeDto> subscribedDtoList = new ArrayList<>();

        for (Subscribe contents : subscribedList) {
            subscribedDtoList.add(new SubscribeDto(contents));
        }
        return subscribedDtoList;
    }






}
