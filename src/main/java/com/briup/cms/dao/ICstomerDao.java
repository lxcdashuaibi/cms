package com.briup.cms.dao;

import com.briup.cms.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICstomerDao extends JpaRepository<Customer,Integer> {
}
