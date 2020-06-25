package com.lwl.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lwl.mybatis.day2.mapper")
public class LwlMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwlMybatisApplication.class, args);
	}

}
