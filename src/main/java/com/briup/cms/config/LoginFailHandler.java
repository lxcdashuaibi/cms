package com.briup.cms.config;

import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: cms
 * @description:
 * @author: wangzh
 * @create: 2019-11-28 10:11
 **/
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
       response.setContentType("application/json;charset=utf-8");//防止乱码，手动转的需要设置 springmvc自动转不需要设置。
        Message<Object> me = MessageUtil.error(403, "登陆失败");
        response.getWriter().println(objectMapper.writeValueAsString(me));
    }
}