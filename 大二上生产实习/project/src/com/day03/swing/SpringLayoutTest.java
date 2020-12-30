package com.day03.swing;

import javax.swing.*;
import java.awt.*;

/*
弹簧布局测试
* */
public class SpringLayoutTest  extends JFrame {
    JPanel jPanel = new JPanel(); // 把面板的布局方式变为 弹簧布局
    JLabel username = new JLabel("文章标题");
    JTextField userTxt = new JTextField(20);
    JLabel pwd = new JLabel("密码");
    JPasswordField pwdTxt = new JPasswordField(20);
    JLabel jLabel = new JLabel("请输入内容");
    JTextArea jTxt = new JTextArea(80,100);
    SpringLayout springLayout;
    public SpringLayoutTest(){
        //
        super("弹簧布局");
        // 设置大小
        setSize(600,600);
        //
        springLayout = new SpringLayout();
        jPanel.setLayout(springLayout);// 面板的布局方式等于弹簧布局


        Font centerFont = new Font("楷体", Font.PLAIN, 20);
        //username.setPreferredSize(new Dimension(300,80));
        username.setFont(centerFont);
        userTxt.setFont(centerFont);
        pwdTxt.setFont(centerFont);
        pwd.setFont(centerFont);
        userTxt.setPreferredSize(new Dimension(0,30) );
        pwdTxt.setPreferredSize(new Dimension(0,30) );
        // 加入组件到面板
        jPanel.add(username);
        jPanel.add(userTxt);
        jPanel.add(pwd);
         jPanel.add(pwdTxt);
        /*jPanel.add(jLabel);
        jPanel.add(jTxt);*/

        // 面板加入到JFrame。

        //springLayout.putConstraint(SpringLayout.WEST,nameField,20,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,username,100,SpringLayout.NORTH,jPanel);
        springLayout.putConstraint(SpringLayout.WEST,username,100,SpringLayout.WEST,jPanel);

        /*userTxt*/
        springLayout.putConstraint(SpringLayout.NORTH,userTxt,0,SpringLayout.NORTH,username);
        springLayout.putConstraint(SpringLayout.WEST,userTxt,20,SpringLayout.EAST,username);
        /*pwd*/
        springLayout.putConstraint(SpringLayout.EAST,pwd,0,SpringLayout.EAST,username);
        springLayout.putConstraint(SpringLayout.NORTH,pwd,20,SpringLayout.SOUTH,username);
        /*
        * pwdTxt
        * */
        springLayout.putConstraint(SpringLayout.WEST,pwdTxt,0,SpringLayout.WEST,userTxt);
        springLayout.putConstraint(SpringLayout.NORTH,pwdTxt,20,SpringLayout.SOUTH,userTxt);


        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(jPanel);

        // 设置位置
        setLocationRelativeTo(null);
        // 设置点击关闭时，退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        SpringLayoutTest springLayoutTest = new SpringLayoutTest();
    }

}
