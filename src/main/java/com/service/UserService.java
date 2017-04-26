package com.service;

import com.config.web.BusinessException;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    public void deleteOne(int uid){
        if (userMapper.deleteOne(uid) != 1) {
            throw new BusinessException("删除失败！");
        }
    }

    public User selectById(int uid){
        User user=userMapper.selectById(uid);
        if (user == null) {
            throw new BusinessException("查无此人！");
        }
        return user;
    }
    public int updateOne(User user){
        return userMapper.updateOne(user);
    }
    public int insertOne(User user){
        return userMapper.insertOne(user);
    }
    public int selectIdByOther(User user){return userMapper.selectIdByOther(user);}
}
