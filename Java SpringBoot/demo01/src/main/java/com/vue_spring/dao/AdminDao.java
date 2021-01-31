package com.vue_spring.dao;

import com.vue_spring.users.Users;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

public interface AdminDao {
    Vector<Vector<Object>> validation(String userName);

    Vector<Object> loading(String name,String pwd);
}
