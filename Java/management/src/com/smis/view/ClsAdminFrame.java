package com.smis.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.smis.common.SqlHelper;
import com.smis.dao.ClsDao;
import com.smis.model.Cls;

public class ClsAdminFrame extends JInternalFrame{
    private JPanel mainPanel;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sp;
    public ClsAdminFrame(){
        super("管理班级", true, true, true, true);
        mainPanel=new JPanel(new BorderLayout());
        String[] headers={"班级编号","班级名称","辅导员","成立时间"};
        model=new DefaultTableModel(headers,0);
        table=new JTable(model);
        sp=new JScrollPane(table);
        //
        fillData();
        //
        setContentPane(mainPanel);
        mainPanel.add(sp,"Center");
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
}