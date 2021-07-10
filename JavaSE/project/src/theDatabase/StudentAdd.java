package theDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentAdd extends JDialog implements ActionListener {
    private JPanel mainPanel;
    private JLabel lblStuId,lblStuName,lblStuSex,lblStuAge;
    private JTextField txtStuId,txtStuName,txtStuAge;
    private JRadioButton rdoMan,rdoWoman;
    private ButtonGroup bg;
    private JButton btnAdd,btnExit;
    public StudentAdd(JFrame frame){
        super(frame,"添加记录",true);
        mainPanel=new JPanel(null);
        lblStuId=new JLabel("学号");
        lblStuName=new JLabel("姓名");
        lblStuSex=new JLabel("性别");
        lblStuAge=new JLabel("年龄");
        txtStuId=new JTextField();
        txtStuName=new JTextField();
        txtStuAge=new JTextField();
        rdoMan=new JRadioButton("男");
        rdoWoman=new JRadioButton("女");
        bg=new ButtonGroup();
        btnAdd=new JButton("添加");
        btnExit=new JButton("退出");
        //
        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
        //
        lblStuId.setBounds(20,20,60,25);
        txtStuId.setBounds(80,20,200,25);
        lblStuName.setBounds(20,55,60,25);
        txtStuName.setBounds(80,55,200,25);
        lblStuSex.setBounds(20,90,60,25);
        rdoMan.setBounds(80,90,60,25);
        rdoWoman.setBounds(150,90,60,25);
        lblStuAge.setBounds(20,125,60,25);
        txtStuAge.setBounds(80,125,200,25);
        btnAdd.setBounds(80,160,60,25);
        btnExit.setBounds(170,160,60,25);
        //
        setContentPane(mainPanel);
        mainPanel.add(lblStuAge);
        mainPanel.add(lblStuId);
        mainPanel.add(lblStuName);
        mainPanel.add(lblStuSex);
        mainPanel.add(txtStuAge);
        mainPanel.add(txtStuId);
        mainPanel.add(txtStuName);
        mainPanel.add(rdoMan);
        mainPanel.add(rdoWoman);
        mainPanel.add(btnAdd);
        mainPanel.add(btnExit);
        bg.add(rdoMan);
        bg.add(rdoWoman);
        ///
        setResizable(false);
        setBounds(100,100,310,240);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.setVisible(false);
        }
        if(e.getSource().equals(btnAdd)){
            try {
                add();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    private void add() throws Exception {
        String stuId=txtStuId.getText();
        String stuName=txtStuName.getText();
        String stuSex="";
        if(rdoMan.isSelected()){
            stuSex="男";
        }else{
            stuSex="女";
        }
        int stuAge=0;
        try {
            stuAge=Integer.parseInt(txtStuAge.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"年龄必须输入数字。");
            return;
        }
        Student stu=new Student();
        stu.setStuId(stuId);
        stu.setStuName(stuName);
        stu.setStuSex(stuSex);
        stu.setStuAge(stuAge);
        StudentDAO dao=new StudentDAO();
        Student s=dao.findById(stuId);
        if(s!=null){
            JOptionPane.showMessageDialog(this, "已经存在该学生，请换一个学号试试。");
            return;
        }
        dao.add(stu);
        SqlHelper.closeConn();
        this.setVisible(false);
    }
}
