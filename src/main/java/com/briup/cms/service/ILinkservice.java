package com.briup.cms.service;

import com.briup.cms.exception.CustomerException;
import com.briup.cms.bean.Link;
public interface ILinkservice {
    void addLink(Link link) throws CustomerException;
    void updateLink(Link link) throws CustomerException;
}
