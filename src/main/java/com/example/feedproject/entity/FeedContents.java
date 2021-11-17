package com.example.feedproject.entity;

import com.example.feedproject.dto.ContentsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FeedContents {
    private List<ContentsDto> contentsDtoList;
}
