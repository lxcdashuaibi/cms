package com.briup.cms.service;


import com.briup.cms.bean.Article;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll() throws CustomerException;
}
