package com.smis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.smis.common.SqlHelper;
import com.smis.dao.ClsDao;
import com.smis.model.Cls;

public class ClsEditFrame extends JInternalFrame implements ActionListener{
    private JLabel lblClsId,lblClsName,lblClsAdmin,lblClsDate;
    private JTextField txtClsId,txtClsName,txtClsAdmin,txtClsDate;
    private JButton btnSave,btnExit;
    private JPanel mainPanel;
    private String clsId;
    public ClsEditFrame(String clsId){
        super("添加班级", false, true, false, true);
        this.clsId=clsId;
        lblClsId=new JLabel("班级编号",JLabel.RIGHT);
        lblClsName=new JLabel("班级名称",JLabel.RIGHT);
        lblClsAdmin=new JLabel("辅导员",JLabel.RIGHT);
        lblClsDate=new JLabel("创建时间",JLabel.RIGHT);
        txtClsId=new JTextField();
        txtClsName=new JTextField();
        txtClsAdmin=new JTextField();
        txtClsDate=new JTextField();
        btnSave=new JButton("保存");
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
        btnSave.setBounds(100,160,60,25);
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
        mainPanel.add(btnSave);
        mainPanel.add(btnExit);
        //
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        //
        fillData();
        //
        setBounds(70,30,340,250);
        setVisible(true);
    }
    private void fillData() {
        try {
            ClsDao dao=new ClsDao();
            Cls cls=dao.findById(clsId);
            txtClsId.setText(cls.getClsId());
            txtClsName.setText(cls.getClsName());
            txtClsAdmin.setText(cls.getClsAdmin());
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            txtClsDate.setText(format.format(cls.getClsTime()));
            txtClsId.setEditable(false);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.dispose();
        }
        if(e.getSource().equals(btnSave)){
            save();
        }
    }
    private void save() {
        Cls cls=new Cls();
        cls.setClsId(clsId);
        cls.setClsName(txtClsName.getText());
        cls.setClsAdmin(txtClsAdmin.getText());
        String time=txtClsDate.getText();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            cls.setClsTime(format.parse(time));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "正确的日期格式为：yyyy-MM-dd");
        }
        try {
            ClsDao dao=new ClsDao();
            dao.update(cls);
            SqlHelper.closeConn();
            this.dispose();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
