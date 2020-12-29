package com.day01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List c1 = new ArrayList();

        c1.add("111");
        c1.add("111");
        c1.add("xxx");
        c1.add("222");
        c1.add("333");

        for (int i = 0;i<c1.size();i++){
            for (int j = i+1;j<c1.size();j++){
                Object i1 = c1.get(i);
                Object j1 = c1.get(j);
                if (i1.equals(j1)){
                    c1.remove(j);
                }
            }
        }

        System.out.println(c1);
    }
}
