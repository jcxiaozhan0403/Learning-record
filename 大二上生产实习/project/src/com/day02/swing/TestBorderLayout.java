package com.day02.swing;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 测试边界布局
 * */
public class TestBorderLayout extends JFrame {
    JButton btn1 = new JButton("按钮1");
    JButton btn2 = new JButton("按钮2");
    JButton btn3 = new JButton("按钮3");
    JButton btn4 = new JButton("按钮4");
    JButton btn5 = new JButton("按钮5");

    public TestBorderLayout() throws MalformedURLException {
        /* 窗体，先创见一个窗体对象*/

        // 设置大小
        setSize(1000,1000);

        // 设置位置

        // 设置点击关闭时，退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗体的布局方式
        setLayout(new BorderLayout());
        // 设置组件的大小
        btn1.setPreferredSize(new Dimension(200,200));
        btn2.setPreferredSize(new Dimension(200,200));
        btn3.setPreferredSize(new Dimension(200,200));
        btn4.setPreferredSize(new Dimension(200,200));
        btn5.setPreferredSize(new Dimension(200,200));

        // 创建组件，放到容器中
        Container contentPane = getContentPane();
        contentPane.add(btn1,BorderLayout.NORTH); //
        contentPane.add(btn2,BorderLayout.SOUTH); //
        contentPane.add(btn3,BorderLayout.WEST); //
        contentPane.add(btn4,BorderLayout.EAST); //
        contentPane.add(btn5,BorderLayout.CENTER); //
        // 把按钮添加到窗体体
        // 设置可见性


        setLocationRelativeTo(null);
        // 设置图片
        URL resource = new URL("https://img.jcxiaozhan.top/%E7%BD%91%E7%AB%99%E5%B0%8F%E5%9B%BE%E6%A0%87.png");
        Image i1 = new ImageIcon(resource).getImage();
        setIconImage(i1);
        // 设置不可调大小
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws MalformedURLException {
        new TestBorderLayout();
    }
}
