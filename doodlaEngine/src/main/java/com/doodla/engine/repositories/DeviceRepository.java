package com.doodla.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doodla.engine.model.Devices;

public interface DeviceRepository extends JpaRepository<Devices, String> {

}