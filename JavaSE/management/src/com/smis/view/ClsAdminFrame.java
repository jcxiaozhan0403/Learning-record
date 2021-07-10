package com.smis.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.smis.common.SqlHelper;
import com.smis.dao.ClsDao;
import com.smis.model.Cls;

public class ClsAdminFrame extends JInternalFrame implements ActionListener{
    private JPanel mainPanel,leftPanel,topPanel;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    private JButton btnDel,btnEdit,btnSearch;
    private JDesktopPane desk;
    private JLabel lblProName,lblProValue;
    private JTextField txtProValue;
    private JComboBox<String> cboProName;
    public ClsAdminFrame(JDesktopPane desk){
        super("管理班级", true, true, true, true);
        this.desk=desk;
        mainPanel=new JPanel(new BorderLayout());
        String[] headers={"班级编号","班级名称","辅导员","成立时间"};
        model=new DefaultTableModel(headers,0);
        table=new JTable(model);
        sp=new JScrollPane(table);
        leftPanel=new JPanel();
        BoxLayout box=new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        leftPanel.setLayout(box);
        topPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnDel=new JButton("删除");
        btnEdit=new JButton("修改");
        btnSearch=new JButton("查询");
        lblProName=new JLabel("请选择字段名",JTextField.RIGHT);
        cboProName=new JComboBox<String>(headers);
        lblProValue=new JLabel("请输入要查询的值",JLabel.RIGHT);
        txtProValue=new JTextField(10);
        //
        fillData();
        //
        btnDel.addActionListener(this);
        btnEdit.addActionListener(this);
        btnSearch.addActionListener(this);
        //
        setContentPane(mainPanel);
        mainPanel.add(sp,"Center");
        mainPanel.add(leftPanel,"West");
        mainPanel.add(topPanel,"North");
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(btnDel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(btnEdit);
        topPanel.add(lblProName);
        topPanel.add(cboProName);
        topPanel.add(lblProValue);
        topPanel.add(txtProValue);
        topPanel.add(btnSearch);
        //
        setBounds(50,50,300,200);
        setVisible(true);
    }
    private void fillData() {
        //移除
        int n=model.getRowCount();
        for(int i=0;i<n;i++){
            model.removeRow(0);
        }
        //
        Object[] objs=new Object[4];
        try {
            ClsDao dao=new ClsDao();
            List<Cls> list=dao.findAll();
            for (Cls cls : list) {
                objs[0]=cls.getClsId();
                objs[1]=cls.getClsName();
                objs[2]=cls.getClsAdmin();
                objs[3]=cls.getClsTime();
                model.addRow(objs);
            }
            SqlHelper.closeConn();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnDel)){
            del();
        }
        if(e.getSource().equals(btnEdit)){
            edit();
        }
        if(e.getSource().equals(btnSearch)){
            search();
        }
    }
    private void search() {
        String name=cboProName.getSelectedItem().toString();
        String proName="clsId";
        if(name.equals("班级名称")){
            proName="clsName";
        }
        if(name.equals("辅导员")){
            proName="clsAdmin";
        }
        if(name.equals("成立时间")){
            proName="clsTime";
        }
        String proValue=txtProValue.getText();
        try {
            ClsDao dao=new ClsDao();
            List<Cls> list=dao.findByProerties(proName,proValue);

            //移除
            int n=model.getRowCount();
            for(int i=0;i<n;i++){
                model.removeRow(0);
            }
            //
            Object[] objs=new Object[4];
            for (Cls cls : list) {
                objs[0]=cls.getClsId();
                objs[1]=cls.getClsName();
                objs[2]=cls.getClsAdmin();
                objs[3]=cls.getClsTime();
                model.addRow(objs);
            }
            SqlHelper.closeConn();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            JOptionPane.showMessageDialog(this, "日期格式为：yyyy-MM-dd");
        }

    }
    private void edit() {
        try {
            String clsId=(String)model.getValueAt(table.getSelectedRow(), 0);
            ClsEditFrame clsEditFrame=new ClsEditFrame(clsId);
            desk.add(clsEditFrame);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "必须选中要修改的记录！");
        }


    }
    private void del() {
        try {
            String clsId=(String)model.getValueAt(table.getSelectedRow(), 0);
            int n=JOptionPane.showConfirmDialog(this, "你真的要删除吗？","删除",JOptionPane.YES_NO_OPTION);
            if(n==1){
                return;
            }
            ClsDao dao=new ClsDao();
            dao.delete(clsId);
            fillData();
            SqlHelper.closeConn();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "必须选中要删除的记录！");
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fillData();
    }
}
