package com.day03.swing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame {
    JPanel jPanel = new JPanel();//面板
    JButton j1 = new JButton("按钮1");
    JButton j2 = new JButton("按钮2");
    JButton j3 = new JButton("按钮3");
    JButton j4 = new JButton("按钮4");
    JButton j5 = new JButton("按钮5");
    JButton j6 = new JButton("按钮6");
    JButton j7 = new JButton("按钮7");
    JButton j8 = new JButton("按钮8");
    FlowLayoutTest(){
        super("这是流布局");
        setSize(600,400);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();
        //先把组件添加到面板
        jPanel.setLayout(new FlowLayout());// 流布局
        //
        jPanel.add(j1);
        jPanel.add(j2);
        jPanel.add(j3);
        jPanel.add(j4);
        jPanel.add(j5);
        jPanel.add(j6);
        jPanel.add(j7);
        jPanel.add(j8);

        // 把面板添加到窗体
        contentPane.add(jPanel);
        // 关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 大小不可以改变
        //setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new  FlowLayoutTest();
    }
}
