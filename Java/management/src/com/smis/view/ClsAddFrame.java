package com.smis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.smis.common.SqlHelper;
import com.smis.dao.ClsDao;
import com.smis.model.Cls;

public class ClsAddFrame extends JInternalFrame implements ActionListener{
    private JLabel lblClsId,lblClsName,lblClsAdmin,lblClsDate;
    private JTextField txtClsId,txtClsName,txtClsAdmin,txtClsDate;
    private JButton btnAdd,btnExit;
    private JPanel mainPanel;
    public ClsAddFrame(){
        super("添加班级", false, true, false, true);
        lblClsId=new JLabel("班级编号",JLabel.RIGHT);
        lblClsName=new JLabel("班级名称",JLabel.RIGHT);
        lblClsAdmin=new JLabel("辅导员",JLabel.RIGHT);
        lblClsDate=new JLabel("创建时间",JLabel.RIGHT);
        txtClsId=new JTextField();
        txtClsName=new JTextField();
        txtClsAdmin=new JTextField();
        txtClsDate=new JTextField();
        btnAdd=new JButton("添加");
        btnExit=new JButton("退出");
        mainPanel=new JPanel(null);
        //
        lblClsId.setBounds(20,20,80,25);//x,y,宽度，高度
        txtClsId.setBounds(100,20,200,25);
        lblClsName.setBounds(20,55,80,25);
        txtClsName.setBounds(100,55,200,25);
        lblClsAdmin.setBounds(20,90,80,25);
        txtClsAdmin.setBounds(100,90,200,25);
        lblClsDate.setBounds(20,125,80,25);
        txtClsDate.setBounds(100,125,200,25);
        btnAdd.setBounds(100,160,60,25);
        btnExit.setBounds(200,160,60,25);
        //
        setContentPane(mainPanel);
        mainPanel.add(lblClsAdmin);
        mainPanel.add(lblClsDate);
        mainPanel.add(lblClsId);
        mainPanel.add(lblClsName);
        mainPanel.add(txtClsAdmin);
        mainPanel.add(txtClsDate);
        mainPanel.add(txtClsId);
        mainPanel.add(txtClsName);
        mainPanel.add(btnAdd);
        mainPanel.add(btnExit);
        //
        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
        //
        setBounds(70,30,340,250);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.dispose();
        }
        if(e.getSource().equals(btnAdd)){
            addCls();
        }
    }
    private void addCls() {
        String clsId=txtClsId.getText();
        String clsName=txtClsName.getText();
        String clsAdmin=txtClsAdmin.getText();
        String date=txtClsDate.getText();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date clsTime=null;
        try {
            clsTime=format.parse(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "正确的日期格式为：YYYY-MM-DD");
            return;
        }
        Cls cls=new Cls();
        cls.setClsId(clsId);
        cls.setClsName(clsName);
        cls.setClsAdmin(clsAdmin);
        cls.setClsTime(clsTime);
        try {
            ClsDao dao=new ClsDao();
            dao.add(cls);
            txtClsId.setText("");
            txtClsName.setText("");
            txtClsAdmin.setText("");
            txtClsDate.setText("");
            SqlHelper.closeConn();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
