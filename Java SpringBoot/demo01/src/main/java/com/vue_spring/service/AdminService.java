package com.vue_spring.service;

import com.vue_spring.users.Users;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

public interface AdminService {
    Vector<Vector<Object>> validation(String userName);
}
