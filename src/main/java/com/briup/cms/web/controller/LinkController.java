package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkservice;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("link")
@Api(description = "链接管理")
public class LinkController {
    @Autowired
    private ILinkservice linkservice;

    @PostMapping("/add")
    @ApiOperation("添加链接")
    public Message addLink(Link link) {
        linkservice.addLink(link);
        return MessageUtil.success();
    }
    @PostMapping("/update")
    @ApiOperation("修改连接")
    public Message updateLink(Link link) {
        linkservice.updateLink(link);
        return MessageUtil.success();
    }

}
