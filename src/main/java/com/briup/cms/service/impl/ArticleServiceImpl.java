package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public void addArticle(Article article) throws CustomerException {
        if (article==null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        articleDao.save(article);
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        articleDao.deleteById(id);
    }

    @Override
    public Article findById(int id) throws CustomerException {
      return articleDao.queryById(id);
    }

    @Override
    public void updateArticle(Article article) throws CustomerException {
        Article article1 = articleDao.queryById(article.getId());

        if (article1==null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        article1.setTitle(article1.getTitle());
        article1.setAuthor(article1.getAuthor());
        //article1.setCategory(article1.getCategory());
        articleDao.save(article1);
    }

    @Override
    public List<Article> findAll() throws CustomerException {
        return  articleDao.findAll();
    }
}
