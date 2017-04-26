package com.model;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**
 * Created by Administrator on 2016/11/30.
 */
@ExcelTarget("user")
public class User {
    @Excel(name = "用户编号",orderNum = "1")
    private int id;

    @Excel(name = "名称",width = 20)
    private String name;

    @Excel(name = "年龄")
    private int age;

    @Excel(name = "密码")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
