package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.People;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/save")
    public String save(){
        for(int i=0;i<100;i++){
            People people=new People();
            people.setId(i+1);
            people.setName("瓜田李下"+i);
            people.setAge(i%5+1);

            peopleService.save(people);
        }

        return "success";
    }

    @RequestMapping("/get")
    public List<People> get(){
        return peopleService.list();
    }

    @RequestMapping("/get2")
    public List<People> get2(){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        wrapper.likeRight("name","瓜田李下");

        return peopleService.list(wrapper);
    }

    @RequestMapping("/get3")
    public List<People> get3(){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("age").orderByAsc("name");

        Page<People> page=new Page<>(1,5);

        IPage<People> iPage=peopleService.page(page,wrapper);
        System.out.println(iPage);
        System.out.println("当前页："+iPage.getCurrent()+"\t 当前条数："+iPage.getSize());
        System.out.println("总页数："+iPage.getPages()+"\t 总条数："+iPage.getTotal());
        System.out.println("当前记录："+iPage.getRecords());

        System.out.println("是否有前一页："+page.hasPrevious()+"\n 是否有后一页："+page.hasNext());
        System.out.println("当前页："+page.getCurrent()+"\t 当前条数："+page.getSize());
        System.out.println("总页数："+page.getPages()+"\t 总条数："+page.getTotal());
        System.out.println("当前记录："+page.getRecords());

        return peopleService.page(page,wrapper).getRecords();
    }

    @RequestMapping("/get4")
    public List<People> get4(){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        wrapper.eq("age",4);

        Page<People> page=new Page<>(1,5);
        IPage<People> iPage=peopleService.page(page,wrapper);

        return iPage.getRecords();
    }

    @RequestMapping("/get5")
    public List<People> get5(){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        wrapper.select("id","name");
        wrapper.eq("age",3);

        return peopleService.list(wrapper);
    }

    @RequestMapping("/get6")
    public List<People> get6(@RequestParam("name") String name,@RequestParam("age") Integer age){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        if(name!=null){
            wrapper.likeRight("name",name);
        }

        if(age!=null){
            wrapper.or().eq("age",age);
        }

        return peopleService.list(wrapper);
    }

    @RequestMapping("/get8")
    public List<Map<String,Object>> get8(){
        QueryWrapper<People> wrapper=new QueryWrapper<>();
        wrapper.select("age,count(*) as count");
        wrapper.groupBy("age");

        return peopleService.listMaps(wrapper);
    }

}

