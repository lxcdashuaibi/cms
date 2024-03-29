package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.dao.ICategoryDao;
import com.briup.cms.dao.ex.ICategoryEXDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private ICategoryEXDao categoryEXDao;

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category==null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        } else {
            categoryDao.save(category);
        }
        Category category1 = categoryDao.queryById(category.getId());
        if (category1 == null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        } else {
            category1.setCode(category1.getCode());
            category1.setName(category1.getName());
            categoryDao.save(category1);
        }
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        categoryDao.deleteById(id);
    }

    @Override
    public Category findById(int id) throws CustomerException {
         return categoryDao.queryById(id);
    }

    @Override
    public List<Category> findAll() throws CustomerException {
        return categoryDao.findAll();
    }

    @Override
    public List<CategoryEX> findAllCategoryEx() throws CustomerException {
        return categoryEXDao.findAll();
    }
}
