package com.example.todo.service;

import com.example.todo.dao.TodoDao;
import com.example.todo.vo.TodoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    @Resource
    private TodoDao dao;

    @Override
    public List<TodoVo> list() throws Exception {
        return dao.findAll();
    }

    @Override
    public void insert(TodoVo vo) throws Exception {
        dao.save(vo);
    }

    @Override
    public void isdone(TodoVo vo) throws Exception {
        TodoVo todo = dao.findById(vo.getSeq()).orElseThrow(() -> new RuntimeException());
        if(todo.isDone() == false) {
            todo.setDone(true);
        } else {
            todo.setDone(false);
        }
        dao.save(todo);
        System.out.println(todo.toString());
    }

    @Override
    public void delete(TodoVo vo) throws Exception {
        dao.deleteById(vo.getSeq());
    }
}
