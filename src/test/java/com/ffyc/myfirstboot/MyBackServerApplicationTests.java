package com.ffyc.myfirstboot;
import com.ffyc.myfirstboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MyBackServerApplicationTests {
	@Autowired
	RedisTemplate redisTemplate;
	@Test
	void contextLoads() {
		ValueOperations valueOperations=redisTemplate.opsForValue();
		valueOperations.set("name","金子豪");
		User user=new User();
		user.setAccount("金子豪");
		user.setPassword("0521");
		valueOperations.set("user1",user);
		valueOperations.set("user2",user,10*1000, TimeUnit.MILLISECONDS);
		System.out.println(redisTemplate.hasKey("key"));

	}

}
