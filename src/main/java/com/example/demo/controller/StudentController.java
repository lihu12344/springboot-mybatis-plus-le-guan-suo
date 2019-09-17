package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public String save(){
        for(int i=0;i<100;i++){
            Student student=new Student();
            student.setId(i+1);
            student.setName("瓜田李下"+i);
            student.setAge(i);

            studentService.save(student);
        }

        return "success";
    }

    @RequestMapping("/get")
    public List<Student> get(){
        return studentService.list();
    }

    @RequestMapping("/get2")
    public List<Student> get2(){
        QueryWrapper<Student> wrapper=new QueryWrapper<>();
        wrapper.eq("name","瓜田李下");
        return studentService.list(wrapper);
    }
}

