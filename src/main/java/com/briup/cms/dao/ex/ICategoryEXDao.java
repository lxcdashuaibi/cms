package com.briup.cms.dao.ex;

import com.briup.cms.bean.ex.CategoryEX;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: cms
 * @description:
 * @author: wangzh
 * @create: 2019-11-29 09:41
 **/
public interface ICategoryEXDao extends JpaRepository<CategoryEX,Integer> {
}