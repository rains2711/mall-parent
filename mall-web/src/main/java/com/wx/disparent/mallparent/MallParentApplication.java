package com.wx.disparent.mallparent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx.disparent.mallparent.dao")
public class MallParentApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallParentApplication.class,args);
    }
}
