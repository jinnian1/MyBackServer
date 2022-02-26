package com.ffyc.myfirstboot.config;

import com.ffyc.myfirstboot.util.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	public void addInterceptors(InterceptorRegistry registry) {
	//	InterceptorRegistration inter =  registry.addInterceptor(new LoginInterceptor());
			//	inter.addPathPatterns("/**");
		//		inter.excludePathPatterns("/api/login/login");
//				inter.excludePathPatterns("/swagger*/**");
//				inter.excludePathPatterns("/v2/**");
//				inter.excludePathPatterns("/webjars/**");
	}
}
