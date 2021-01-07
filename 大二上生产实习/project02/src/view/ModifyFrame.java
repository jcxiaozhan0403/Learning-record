package view;

import dao.StudentDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyFrame extends JDialog implements ActionListener{
    private ModifyFrame modifyFrame;
    private JLabel lblClsId,lblClsName,lblClsSex,lblClsAge,lblClsNo;
    private JTextField txtClsId,txtClsName,txtClsSex,txtClsAge,txtClsNo;
    private JButton btnSave,btnExit;
    private JPanel mainPanel;
    public ModifyFrame(String stuId, String stuName, String stuSex, int stuAge,String stuCls,MainView mainView){
        super(mainView,"修改信息");
        lblClsId=new JLabel("学号",JLabel.RIGHT);
        lblClsName=new JLabel("姓名",JLabel.RIGHT);
        lblClsSex=new JLabel("性别",JLabel.RIGHT);
        lblClsAge=new JLabel("年龄",JLabel.RIGHT);
        lblClsNo=new JLabel("班级",JLabel.RIGHT);
        txtClsId=new JTextField();
        txtClsName=new JTextField();
        txtClsSex=new JTextField();
        txtClsAge=new JTextField();
        txtClsNo=new JTextField();
        btnSave=new JButton("保存");
        btnExit=new JButton("退出");
        mainPanel=new JPanel(null);
        //
        lblClsId.setBounds(20,20,80,25);//x,y,宽度，高度
        txtClsId.setBounds(100,20,200,25);
        lblClsName.setBounds(20,55,80,25);
        txtClsName.setBounds(100,55,200,25);
        lblClsSex.setBounds(20,90,80,25);
        txtClsSex.setBounds(100,90,200,25);
        lblClsAge.setBounds(20,125,80,25);
        txtClsAge.setBounds(100,125,200,25);
        lblClsNo.setBounds(20,160,80,25);
        txtClsNo.setBounds(100,160,200,25);
        btnSave.setBounds(100,195,60,25);
        btnExit.setBounds(200,195,60,25);

        //
        txtClsId.setText(stuId);
        txtClsName.setText(stuName);
        txtClsSex.setText(stuSex);
        txtClsAge.setText(Integer.toString(stuAge));
        txtClsNo.setText(stuCls);
        txtClsId.setEditable(false);
        //
        setContentPane(mainPanel);
        mainPanel.add(lblClsSex);
        mainPanel.add(lblClsAge);
        mainPanel.add(lblClsId);
        mainPanel.add(lblClsName);
        mainPanel.add(txtClsSex);
        mainPanel.add(txtClsAge);
        mainPanel.add(txtClsId);
        mainPanel.add(txtClsName);
        mainPanel.add(lblClsNo);
        mainPanel.add(txtClsNo);
        mainPanel.add(btnSave);
        mainPanel.add(btnExit);
        //
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        //
        setLocation(800,400);
        setSize(340,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.dispose();
        }
        if(e.getSource().equals(btnSave)){

            String stuId,stuName,stuSex,stuCls;
            int stuAge;

            stuId = txtClsId.getText();
            stuName = txtClsName.getText();
            stuSex = txtClsSex.getText();
            stuAge = Integer.parseInt(txtClsAge.getText());
            stuCls = txtClsNo.getText();
            try {
                StudentDao.modifly(stuId,stuName,stuSex,stuAge,stuCls);
                MainView.loadTableData();
                MainView.tableStyle();
                this.dispose();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(modifyFrame,"请正确填写学生信息");
            }
        }
    }
}