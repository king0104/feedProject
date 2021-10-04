package com.example.feedproject.repository;

import com.example.feedproject.entity.Contents;
import com.example.feedproject.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

}