package com.example.todo.service;

import com.example.todo.vo.TodoVo;

import java.util.List;

public interface TodoService {
    public List<TodoVo> list() throws Exception;

    public void insert(TodoVo vo) throws Exception;

    public void isdone(TodoVo vo) throws Exception;
    public void delete(TodoVo vo) throws Exception;
}
