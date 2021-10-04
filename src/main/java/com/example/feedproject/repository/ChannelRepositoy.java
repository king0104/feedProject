package com.example.feedproject.repository;

import com.example.feedproject.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepositoy extends JpaRepository<Channel, Long> {
}
