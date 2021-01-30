package com.vue_spring.service;

import com.vue_spring.dao.AdminDao;
import com.vue_spring.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public String validation(String userName) {
        return adminDao.validation(userName);
    }
}
