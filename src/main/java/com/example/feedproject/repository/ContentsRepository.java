package com.example.feedproject.repository;

import com.example.feedproject.dto.ContentsDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feedproject.entity.Contents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {

//    @Query (value = "select * from Contents where channel_name = cn", nativeQuery = true)
//    List<Contents> findContentsByChannelName(@Param(value = "cn") String channelName);

      List<Contents> findContentsByChannelName(String channelName);
}
