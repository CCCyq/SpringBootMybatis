package com;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2016/11/30.
 */
//自动扫描包和自动配置默认配置
//包含@ComponentScan和@EnableAutoConfiguration 两个注解
@SpringBootApplication
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
        System.out.println("test ");
    }

}
