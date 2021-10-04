package com.example.feedproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feedproject.entity.Contents;


public interface ContentsRepository extends JpaRepository<Contents, Long> {

}
