package com.day02.swing;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * 创建容器
 *
 * 创建组件，放到容器中。
 *
 * */
public class Test {
    public static void main(String[] args) throws MalformedURLException {
        /* 窗体，先创见一个窗体对象*/
        JFrame jFrame = new JFrame("JC小站应用程序");
        jFrame.setLayout(null);
        // 设置大小
        jFrame.setSize(300,400);

        // 设置位置
        jFrame.setLocationRelativeTo(null);
        // 设置图片
        URL resource = new URL("https://img.jcxiaozhan.top/%E7%BD%91%E7%AB%99%E5%B0%8F%E5%9B%BE%E6%A0%87.png");
        Image i1 = new ImageIcon(resource).getImage();
        jFrame.setIconImage(i1);
        // 设置不可调大小
        jFrame.setResizable(false);
        // 设置点击关闭时，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置可见性

        // 创建组件，放到容器中
        JButton jButton = new JButton("按钮1");//
        // 设置按钮大小
        jButton.setSize(100,200);

        Container contentPane = jFrame.getContentPane();
        // 把按钮添加到窗体体
        contentPane.add(jButton);
        jFrame.setVisible(true);
    }
}