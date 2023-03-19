package com.spingboot.spingbootfirst.controller;

import com.spingboot.spingbootfirst.config.JsonResult;
import com.spingboot.spingbootfirst.domain.Dept;
import com.spingboot.spingbootfirst.domain.User;
import com.spingboot.spingbootfirst.service.DeptBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FirstSpringBoot {
    private static final Logger logger = LoggerFactory.getLogger(FirstSpringBoot.class);

    @Resource
    private  DeptBiz deptbiz;

    @RequestMapping(value ="/boot", method = RequestMethod.GET)
    public String firstDemo(){
        return "hello SpringBoot";
    }

    @RequestMapping(value ="/getuUserInfo", method = RequestMethod.GET)
    public User getuUserInfo(){
        User user = new User(1, "小龟王", "123456");
        return user;
    };
    @RequestMapping(value ="/getuUserList", method = RequestMethod.GET)
    public List<User> getuUserList(){
        List<User>  userList=new ArrayList<User>();
        User user = new User(1, "小翔王", "123456");
        User user1 = new User(2, "大翔王", "123456");
        User user2 = new User(3, "瓜蛋狗", "123456");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);


        logger.info("这个list是 {}",userList);

        return userList;

    }
    @RequestMapping(value ="/getuUserMap", method = RequestMethod.GET)
    public Map<String ,User> getuUserMap(){
        Map<String ,User>  userMap=new HashMap<>();
        User user = new User(1, "小翔王", "123456");
        User user1 = new User(2, "大翔王", null);
        User user2 = new User(3, "瓜蛋狗", "123456");
        userMap.put("员工一",user);
        userMap.put("员工二",user1);
        userMap.put("员工三",user2);

        return userMap;
    }

    @RequestMapping(value ="/addUserInfo" ,method =RequestMethod.POST )
    public String addUserInfo ( @RequestBody User user ){
        List<User> userList=new ArrayList<User>();
        userList.add(user);
        logger.info("本次增加的数据是{}",userList);
        return new JsonResult<>(userList).toString()
                ;
    }

    @RequestMapping(value ="/getDpetBydeptnu", method = RequestMethod.GET)
    public Dept getDpetBydeptnuInfo(){

        Dept dept = deptbiz.selectById(10);
        logger.info("打印结果{}",dept.toString());

        return dept;
    }
}

