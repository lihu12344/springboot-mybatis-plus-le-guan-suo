package com.example.demo.serviceImpl;

import com.example.demo.pojo.Student;
import com.example.demo.dao.StudentMapper;
import com.example.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihu
 * @since 2019-09-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
