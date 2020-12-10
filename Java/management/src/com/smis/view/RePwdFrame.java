package com.smis.view;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RePwdFrame extends JInternalFrame{
    private JPanel mainPanel;
    private JLabel lblOldPwd,lblNewPwd,lblRePwd;
    private JPasswordField txtOldPwd,txtNewPwd,txtRePwd;
    private JButton btnSave,btnExit;
    private String adminId;
    public RePwdFrame(String adminId) {
        super("修改密码", false, true, false, true);
        this.adminId=adminId;
        //
        mainPanel=new JPanel(null);
        lblOldPwd=new JLabel("请输入旧密码",JLabel.RIGHT);
        lblNewPwd=new JLabel("请输入新密码",JLabel.RIGHT);
        lblRePwd=new JLabel("请再次确认密码",JLabel.RIGHT);
        txtOldPwd=new JPasswordField();
        txtNewPwd=new JPasswordField();
        txtRePwd=new JPasswordField();
        btnSave=new JButton("保存");
        btnExit=new JButton("退出");
        //
        lblOldPwd.setBounds(10,10,120,25);
        txtOldPwd.setBounds(130,10,200,25);
        lblNewPwd.setBounds(10,45,120,25);
        txtNewPwd.setBounds(130,45,200,25);
        lblRePwd.setBounds(10,80,120,25);
        txtRePwd.setBounds(130,80,200,25);
        btnSave.setBounds(130,115,60,25);
        btnExit.setBounds(210,115,60,25);
        //
        setContentPane(mainPanel);
        mainPanel.add(lblNewPwd);
        mainPanel.add(lblOldPwd);
        mainPanel.add(lblRePwd);
        mainPanel.add(txtNewPwd);
        mainPanel.add(txtOldPwd);
        mainPanel.add(txtRePwd);
        mainPanel.add(btnExit);
        mainPanel.add(btnSave);
        //
        setBounds(50,50,400,190);
        setVisible(true);
    }

}