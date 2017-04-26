package com.controller;

import com.config.web.ApiResult;
import com.config.web.BusinessException;
import com.model.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 * 访问   http://localhost:8082/select
 */
@RestController
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("select")
    public ModelAndView selectAll(){
        logger.info("查询所有的用户信息");
        List<User> user=userService.selectAll();

        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("userList", user);
        return modelAndView;
    }

    @RequestMapping(value = "delete.do",method = RequestMethod.GET)
    public ApiResult ajax1(@RequestParam(value = "u_id") int uid){
        userService.deleteOne(uid);
        return ApiResult.success("删除成功",uid);
    }

    @RequestMapping(value="insert.do",method = RequestMethod.POST)
    public ApiResult ajax2(@RequestParam("u_name") String name,
                      @RequestParam("u_age") int age,
                      @RequestParam("u_pwd") String password){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);
        int temp = userService.insertOne(user);
        logger.info(temp==1?"插入成功！":"插入失败！");
        int id=userService.selectIdByOther(user);
        user.setId(id);
        return ApiResult.success(user);
    }

    @RequestMapping(value = "selectOne.do",method = RequestMethod.GET)
    public ApiResult ajax3(@RequestParam(value = "u_id") int uid){
        User user=userService.selectById(uid);
        logger.info("查询id="+user.getId()+"的数据");
        return ApiResult.success(user);
    }

    @RequestMapping(value="updateOne.do",method = RequestMethod.POST)
    public ApiResult ajax4(@RequestParam(value = "u_id") int id,
                      @RequestParam(value = "u_name") String name,
                      @RequestParam(value = "u_age") int age,
                      @RequestParam(value = "u_pwd") String password)
    {
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);
        int temp=userService.updateOne(user);
        logger.info(temp==1?"更新成功！":"更新失败！");
        return ApiResult.success(user);
    }
    /*@RequestMapping("delete")
    public ModelAndView deleteOne(@RequestParam(value = "u_id") int uid, Model model){
        int temp=userService.deleteOne(uid);
        if(temp==1){
            logger.info("删除成功！");
        }else {
            logger.info("删除失败！");
        }
        selectAll(model);
        return new ModelAndView("user");
    }

    @RequestMapping(value = "selectOne")
    public ModelAndView selectOne(@RequestParam(value = "u_id") int uid, Model model){
        User user=userService.selectById(uid);
        model.addAttribute("OneUser",user);
        logger.info("查询id="+user.getId()+"的数据");
        return new ModelAndView("update");
    }
    @RequestMapping(value="updateOne",method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(value = "u_id") int id,
                            @RequestParam(value = "u_name") String name,
                            @RequestParam(value = "u_age") int age,
                            @RequestParam(value = "u_pwd") String password,
                            Model model)
    {
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);

        int temp=userService.updateOne(user);
        if(temp==1){
            logger.info("更新name="+user.getName()+"成功");
        }else {
            logger.info("更新name="+user.getName()+"失败");
        }
        selectAll(model);
        return new ModelAndView("user");
    }
    @RequestMapping(value="insertOne",method = RequestMethod.POST)
    public ModelAndView insertOne(@RequestParam("u_name") String name,
                            @RequestParam("u_age") int age,
                            @RequestParam("u_pwd") String password,
                            Model model){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);

        int temp = userService.insertOne(user);
        if(temp==1){
            logger.info("插入成功");
        }else {
            logger.info("插入失败");
        }
        selectAll(model);
        return new ModelAndView("user");
    }*/
}
