package com.doodla.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doodla.engine.model.Likes;


public interface LikeRepository extends JpaRepository<Likes, String> {


}