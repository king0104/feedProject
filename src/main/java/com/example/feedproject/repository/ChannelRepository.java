package com.example.feedproject.repository;

import com.example.feedproject.dto.ChannelDto;
import com.example.feedproject.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> { // 엔티티, 해당 객체의 pk 타입

//    @Query(value = "select * from Channel where name = ?", nativeQuery = true)
//    Channel findChannelByName(String name);

    Channel findChannelByName(String name);
}
