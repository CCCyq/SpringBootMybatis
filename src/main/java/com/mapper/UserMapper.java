package com.mapper;

import com.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
@Mapper
public interface UserMapper {

    List<User> selectAll();
    int deleteOne(int uid);
    User selectById(int uid);
    int updateOne(User user);
    int insertOne(User user);
    int selectIdByOther(User user);
}
