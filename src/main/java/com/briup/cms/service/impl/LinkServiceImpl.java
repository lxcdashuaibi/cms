package com.briup.cms.service.impl;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.ILinkDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    private ILinkDao linkDao;

    @Override
    public void saveOrUpdate(Link link) throws CustomerException {
        if(link==null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"没有这个链接");
        } else {
            linkDao.save(link);
        }
        Link link1 = linkDao.queryById(link.getId());
        if (link1==null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"没有这个链接");
        } else {
            link1.setName(link1.getName());
            link1.setUrl(link1.getUrl());
            linkDao.save(link1);
        }
    }
    @Override
    public void deleteLink(int id) throws CustomerException {
        linkDao.deleteById(id);
    }

    @Override
    public Link findById(int id) throws CustomerException {
        return linkDao.queryById(id);
    }

    @Override
    public List<Link> findAll() throws CustomerException {
        return linkDao.findAll();
    }

}
