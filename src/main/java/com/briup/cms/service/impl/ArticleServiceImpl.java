package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public List<Article> findAll() throws CustomerException {
        return  articleDao.findAll();
    }
}
