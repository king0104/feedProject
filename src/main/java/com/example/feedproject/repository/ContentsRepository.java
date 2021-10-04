package com.example.feedproject.repository;

import com.example.feedproject.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ContentsRepository extends JpaRepository<Contents, Long> {

}
