package com.sss;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyWin extends JFrame implements ActionListener {
    public JPanel mainPanel; //面板
    public JLabel lblLogin,lblUserName,lblUserPwd; //标签
    public  JTextField txtUserName;
    public JPasswordField txtPwd;
    public JButton btnLogin,btnExit;

    public MyWin(){
        setTitle("我的窗口");
        this.setBounds(200,200,500,300);

        ////

        mainPanel = new JPanel(null);
        this.setContentPane(mainPanel);
        lblLogin = new JLabel("用户登录");
        Font font = new Font("STXingkai",Font.BOLD,32);
        lblLogin.setFont(font);
        lblLogin.setForeground(Color.lightGray);
        lblUserName = new JLabel("用户名");
        lblUserPwd = new JLabel("密码");
        txtUserName = new JTextField(30);
        txtPwd = new JPasswordField(30);
        btnLogin = new JButton("登录");
        btnExit = new JButton("退出");

        //
        btnLogin.addActionListener(ture);
        btnExit.addActionListener(ture);

        lblLogin.setBounds(180,20,200,50);
        lblUserName.setBounds(110,80,90,30);
        lblUserPwd.setBounds(110,120,90,30);
        txtUserName.setBounds(170,85,180,20);
        txtPwd.setBounds(170,125,180,20);
        btnLogin.setBounds(150,165,60,30);
        btnExit.setBounds(300,165,60,30);

        mainPanel.add(lblLogin);
        mainPanel.add(lblUserName);
        mainPanel.add(txtUserName);
        mainPanel.add(lblUserPwd);
        mainPanel.add(txtPwd);
        mainPanel.add(btnLogin);
        mainPanel.add(btnExit);

        ////
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MyWin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnLogin)){
            JOptionPane.showConfirmDialog(this,"登录按钮被点击！");
        }
        if(e.getActionCommand().equals("退出")){
            System.exit(0);
        }
    }
}