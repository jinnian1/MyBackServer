package com.ffyc.myfirstboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication是springboot核心注解,其中包含
     @ComponentScan它默认扫描的是与该类同级的类或者同级包下的所有类
	 @EnableAutoConfiguration是这里最重要的注解，它实现了对Spring Boot应用自动装配的功能*/
@SpringBootApplication
@MapperScan("com.ffyc.myfirstboot.dao")
public class MyBackServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBackServerApplication.class, args);
	}
}
