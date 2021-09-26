package com.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AfterLog implements AfterReturningAdvice {
  //returnValue 返回值
          //method被调用的方法
          //args 被调用的方法的对象的参数
          //target 被调用的目标对象
          @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    System.out.println("执行了" + target.getClass().getName()
                   +"的"+method.getName()+"方法,"
    +"返回值："+returnValue);
   }
}