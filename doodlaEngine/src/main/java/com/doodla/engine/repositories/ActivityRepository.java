package com.doodla.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doodla.engine.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {


}