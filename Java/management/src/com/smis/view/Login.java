package com.smis.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    private JLabel lblTitle,lblUserId,lblUserPwd;
    private JTextField txtUserId;
    private JPasswordField txtUserPwd;
    private JButton btnLogin,btnExit;
    private JPanel mainPanel;
    public Login(){
        mainPanel=new JPanel(null);
        lblTitle=new JLabel("学生管理系统",JLabel.CENTER);
        lblUserId=new JLabel("登录号",JLabel.RIGHT);
        lblUserPwd=new JLabel("密码",JLabel.RIGHT);
        txtUserId=new JTextField();
        txtUserPwd=new JPasswordField();
        btnLogin=new JButton("登录");
        btnExit=new JButton("退出");
        //设置位置和大小
        lblTitle.setBounds(90,20,200,50);
        lblUserId.setBounds(20,80,75,25);
        txtUserId.setBounds(95,80,200,25);
        lblUserPwd.setBounds(20,115,75,25);
        txtUserPwd.setBounds(95,115,200,25);
        btnLogin.setBounds(110,150,60,25);
        btnExit.setBounds(210,150,60,25);
        //将控件放入容器
        setContentPane(mainPanel);
        mainPanel.add(lblTitle);
        mainPanel.add(lblUserId);
        mainPanel.add(lblUserPwd);
        mainPanel.add(txtUserId);
        mainPanel.add(txtUserPwd);
        mainPanel.add(btnExit);
        mainPanel.add(btnLogin);
        //
        lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 20));

        //
        btnExit.addActionListener(this);
        btnLogin.addActionListener(this);

        //设置窗口
        setBounds(200,200,370,250);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnExit)){
            System.exit(0);
        }
        if (e.getSource().equals(btnLogin)){
            userLogin();
        }
    }

    private void userLogin() {
        
    }
}