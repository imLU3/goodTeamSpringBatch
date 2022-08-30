package com.batch.goodTeam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.goodTeam.entity.MyUser;

public interface CsvToH2DbRepo extends JpaRepository<MyUser, Integer>{

}
