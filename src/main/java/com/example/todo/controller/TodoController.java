package com.example.todo.controller;

import com.example.todo.service.TodoService;
import com.example.todo.vo.TodoVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TodoController {

    @Resource
    TodoService service;

    @RequestMapping("/")
    public String home(Model model) throws Exception {
        List<TodoVo> todoList = service.list();
        model.addAttribute("todoList", todoList);
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String post_home(TodoVo vo) throws Exception {
        service.insert(vo);
        return "redirect:/";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String post_done(TodoVo vo) throws Exception {
        service.isdone(vo);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String post_delete(TodoVo vo) throws Exception {
        service.delete(vo);
        return "redirect:/";
    }
}
