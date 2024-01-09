package com.todo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.ToDoEntity;

public interface ToDoService extends JpaRepository<ToDoEntity, Integer> {

}
