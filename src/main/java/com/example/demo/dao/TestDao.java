package com.example.demo.dao;

import com.example.demo.entity.TestEntity;

import org.springframework.data.repository.CrudRepository;

public interface TestDao extends CrudRepository<TestEntity, Long> {
}
