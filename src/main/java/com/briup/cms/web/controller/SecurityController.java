package com.briup.cms.web.controller;

import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @program: cms
 * @description:
 * @author: wangzh
 * @create: 2019-11-28 10:37
 **/
@RestController
@ApiIgnore
public class SecurityController {

    @GetMapping("/authenticaion/login")
    public Message logg() {
        return MessageUtil.error(403,"该用户没有登陆，请跳转到登陆页面");
    }
}