package com.example.todo.dao;

import com.example.todo.vo.TodoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends JpaRepository<TodoVo, Integer> {

}