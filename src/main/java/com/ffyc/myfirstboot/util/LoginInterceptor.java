package com.ffyc.myfirstboot.util;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

  /*  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String toke =request.getHeader("token");
        boolean flag=TokenUtil.verify(toke);
        if(flag){
            return  true;
        }else{
            response.getWriter().println(401);
            return  false;
        }
    }*/
}
