package com.example.feedproject.repository;

import com.example.feedproject.dto.SubscribeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feedproject.entity.Subscribe;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

//    @Query(value = "select * from subscribe where from_channel = ?", nativeQuery = true)
//    List<SubscribeDto> findSubscribeByFromChannel(String fromChannel);

//      List<SubscribeDto> findSubscribeByFromChannel(String fromChannel);
      List<Subscribe> findSubscribeByFromChannel(String fromChannel);
}
