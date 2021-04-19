package com.vue_spring.service;

import com.vue_spring.dao.AdminDao;
import com.vue_spring.dao.AdminDaoImpl;
import com.vue_spring.users.Users;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Vector<Vector<Object>> validation(String userName) {
        return adminDao.validation(userName);
    }
}
