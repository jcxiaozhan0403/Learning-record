package theDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame implements ActionListener, WindowFocusListener {
    private JPanel mainPanel,leftPanel,topPanel;
    private JTable table;
    private JScrollPane js;
    private DefaultTableModel dm;
    private JButton btnAdd,btnDel,btnEdit,btnSearch;
    private JComboBox<String> cboProName;
    private JTextField txtProValue;
    private JLabel lblProName,lblProValue;

    public StudentView(){
        mainPanel=new JPanel(new BorderLayout());
        String [] headers={"学号","姓名","性别","年龄"};
        dm=new DefaultTableModel(headers,0);
        table=new JTable(dm);
        js=new JScrollPane(table);
        ///
        topPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSearch=new JButton("查询");
        cboProName=new JComboBox<String>(headers);
        txtProValue=new JTextField(10);
        lblProName=new JLabel("选择查询的字段");
        lblProValue=new JLabel("输入查询的值");
        ///
        leftPanel=new JPanel();
        BoxLayout box=new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
        leftPanel.setLayout(box);
        btnAdd=new JButton("添加");
        btnDel=new JButton("删除");
        btnEdit=new JButton("修改");
        //监听
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnEdit.addActionListener(this);
        this.addWindowFocusListener(this);
        btnSearch.addActionListener(this);
        //
        try {
            fillData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        setContentPane(mainPanel);
        mainPanel.add(js,"Center");
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(btnAdd);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(btnDel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(btnEdit);
        mainPanel.add(leftPanel,"West");

        topPanel.add(lblProName);
        topPanel.add(cboProName);
        topPanel.add(lblProValue);
        topPanel.add(txtProValue);
        topPanel.add(btnSearch);
        mainPanel.add(topPanel,"North");

        //
        setBounds(200,200,500,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void fillData() throws Exception {
        //清空数据
        int n=dm.getRowCount();
        for(int i=0;i<n;i++){
            dm.removeRow(0);
        }
        //填充数据
        StudentDAO dao=new StudentDAO();
        List<Student> list=dao.findAll();
        Object[] objs=new Object[4];
        for (Student s : list) {
            objs[0]=s.getStuId();
            objs[1]=s.getStuName();
            objs[2]=s.getStuSex();
            objs[3]=s.getStuAge();
            dm.addRow(objs);
        }
        SqlHelper.closeConn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAdd)){
            add();
        }
        if(e.getSource().equals(btnDel)){
            try {
                del();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if(e.getSource().equals(btnEdit)){
            edit();
        }
        if(e.getSource().equals(btnSearch)){
            try {
                search();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    private void search() throws Exception {
        String name=cboProName.getSelectedItem().toString();
        String proName="";
        if(name.equals("学号")){
            proName="stuId";
        }
        if(name.equals("姓名")){
            proName="stuName";
        }
        if(name.equals("性别")){
            proName="stuSex";
        }
        if(name.equals("年龄")){
            proName="stuAge";
        }
        Object proValue=txtProValue.getText();
        if(proName.equals("年龄")){
            try {
                proValue=Integer.parseInt(txtProValue.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "年龄只能输入整数！");
                return;
            }
        }
        StudentDAO dao=new StudentDAO();
        List<Student> list=dao.findByProperty(proName, proValue);
        //清空数据
        int n=dm.getRowCount();
        for(int i=0;i<n;i++){
            dm.removeRow(0);
        }
        //填充数据
        Object[] objs=new Object[4];
        for (Student s : list) {
            objs[0]=s.getStuId();
            objs[1]=s.getStuName();
            objs[2]=s.getStuSex();
            objs[3]=s.getStuAge();
            dm.addRow(objs);
        }
        SqlHelper.closeConn();
    }
    private void edit() {
        if(table.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this,"您必须选择一条记录！");
            return;
        }
        Object obj=dm.getValueAt(table.getSelectedRow(), 0);
        String stuId=obj.toString();
        new StudentEdit(this,stuId);
    }
    private void add() {
        new StudentAdd(this);
    }
    private void del() throws Exception {
        Object obj=dm.getValueAt(table.getSelectedRow(), 0);
        //JOptionPane.showMessageDialog(this, obj);
        StudentDAO dao=new StudentDAO();
        dao.delete(obj.toString());
        fillData();
        SqlHelper.closeConn();
    }
    @Override
    public void windowGainedFocus(WindowEvent e) {
        try {
            fillData();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    @Override
    public void windowLostFocus(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new StudentView();
    }
}