package com.smis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.smis.common.SqlHelper;
import com.smis.dao.AdminDao;
import com.smis.model.Admin;

public class RePwdFrame extends JInternalFrame implements ActionListener{
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
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.dispose();//销毁
        }
        if(e.getSource().equals(btnSave)){
            save();
        }
    }
    private void save() {
        String oldPwd=new String(txtOldPwd.getPassword());
        String newPwd=new String(txtNewPwd.getPassword());
        String rePwd=new String(txtRePwd.getPassword());
        Md5PasswordEncoder md5=new Md5PasswordEncoder();
        try {
            AdminDao dao=new AdminDao();
            Admin admin=dao.findById(adminId);
            if(!md5.encodePassword(oldPwd, 1).equals(admin.getAdminPwd())){
                JOptionPane.showMessageDialog(this, "旧密码输入错误！");
                SqlHelper.closeConn();
                return;
            }
            if(!newPwd.equals(rePwd)){
                JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
                SqlHelper.closeConn();
                return;
            }
            admin.setAdminPwd(md5.encodePassword(newPwd, 1));
            dao.update(admin);
            JOptionPane.showMessageDialog(this, "密码修改成功！");
            SqlHelper.closeConn();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
