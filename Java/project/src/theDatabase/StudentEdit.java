package theDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentEdit extends JDialog implements ActionListener {
    private JPanel mainPanel;
    private JLabel lblStuId,lblStuName,lblStuSex,lblStuAge;
    private JTextField txtStuId,txtStuName,txtStuAge;
    private JRadioButton rdoMan,rdoWoman;
    private ButtonGroup bg;
    private JButton btnSave,btnExit;
    private String stuId;
    public StudentEdit(JFrame frame,String stuId){
        super(frame,"修改记录",true);
        this.stuId=stuId;
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
        btnSave=new JButton("保存");
        btnExit=new JButton("退出");
        ///
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        ////
        lblStuId.setBounds(20,20,60,25);
        txtStuId.setBounds(80,20,200,25);
        lblStuName.setBounds(20,55,60,25);
        txtStuName.setBounds(80,55,200,25);
        lblStuSex.setBounds(20,90,60,25);
        rdoMan.setBounds(80,90,60,25);
        rdoWoman.setBounds(150,90,60,25);
        lblStuAge.setBounds(20,125,60,25);
        txtStuAge.setBounds(80,125,200,25);
        btnSave.setBounds(80,160,60,25);
        btnExit.setBounds(170,160,60,25);
        ////
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
        mainPanel.add(btnSave);
        mainPanel.add(btnExit);
        bg.add(rdoMan);
        bg.add(rdoWoman);
        ///填充数据
        try {
            fillData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ///
        setResizable(false);
        setBounds(100,100,310,240);
        setVisible(true);

    }
    private void fillData() throws Exception {
        StudentDAO dao=new StudentDAO();
        Student stu=dao.findById(stuId);
        txtStuId.setText(stu.getStuId());
        txtStuName.setText(stu.getStuName());
        txtStuAge.setText(stu.getStuAge()+"");
        if(stu.getStuSex().equals("男")){
            rdoMan.setSelected(true);
        }else{
            rdoWoman.setSelected(true);
        }
        txtStuId.setEditable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            this.setVisible(false);
        }
        if(e.getSource().equals(btnSave)){
            try {
                save();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
    private void save() throws Exception {
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
        dao.edit(stu);
        SqlHelper.closeConn();
        this.setVisible(false);
    }
}
