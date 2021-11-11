package com.example.feedproject.business;

import com.example.feedproject.dto.ContentsDto;
import com.example.feedproject.entity.Contents;
import com.example.feedproject.repository.ContentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContentsBusiness {

    private final ContentsRepository contentsRepository;

//    public List<ContentsDto> createContentsDto(String channelName) {
//        List<Contents> contentsList = contentsRepository.findContentsByChannelName(channelName);
//        List<ContentsDto> contentsDtoList = new ArrayList<>();
//
//        for (Contents contents : contentsList) {
//            contentsDtoList.add(new ContentsDto(contents));
//        }
//        return contentsDtoList;
//    }

    public List<ContentsDto> createContentsDtoList(List<Contents> contentsList) {
        List<ContentsDto> contentsDtoList = new ArrayList<>();

        for (Contents contents : contentsList) {
            contentsDtoList.add(new ContentsDto(contents));
        }
        return contentsDtoList;
    }
}
