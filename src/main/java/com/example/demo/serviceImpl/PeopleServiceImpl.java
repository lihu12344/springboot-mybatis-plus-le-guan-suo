package com.example.demo.serviceImpl;

import com.example.demo.pojo.People;
import com.example.demo.dao.PeopleMapper;
import com.example.demo.service.PeopleService;
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
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {

}
