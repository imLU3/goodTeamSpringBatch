package com.batch.goodTeam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.goodTeam.entity.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
}
