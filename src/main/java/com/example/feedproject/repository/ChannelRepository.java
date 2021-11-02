package com.example.feedproject.repository;

import com.example.feedproject.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> { // 엔티티, 해당 객체의 pk 타입

}
