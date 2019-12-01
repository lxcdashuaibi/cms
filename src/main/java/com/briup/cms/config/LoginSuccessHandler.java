package com.briup.cms.config;

import com.briup.cms.exception.CustomerException;
import com.briup.cms.util.JwtTokenUtils;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: cms
 * @description:
 * @author: wangzh
 * @create: 2019-11-28 10:09
 **/
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;//将对象转json

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

            String token = JwtTokenUtils.createToken(userDetails, false);//产生token

            token = JwtTokenUtils.TOKEN_PREFIX + token;//将token以json的形式返回，并且放在请求头中

            response.setHeader(JwtTokenUtils.TOKEN_HEADER,token);

            Message<String> message = MessageUtil.success(token);
            response.getWriter().println(objectMapper.writeValueAsString(message));//将对象转json
        } catch (Exception e) {
            Message<Object> message = MessageUtil.error(403, "登陆失败");
            response.getWriter().println(objectMapper.writeValueAsString(message));
        }


    }
}