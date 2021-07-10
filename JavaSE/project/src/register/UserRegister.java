package register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegister extends JFrame implements ActionListener {
    private JPanel mainPanel;//面板
    private JLabel lblNo,lblName,lblSex,lblAge,lblCls,lblHobby,lblNote;//标签
    private JTextField txtNo,txtName,txtAge;//单行文本框
    private JRadioButton rdoSexMan,rdoSexWoman;//单选框
    private ButtonGroup bg;//组合按钮
    private JComboBox<String> cboCls;//下拉框
    private JCheckBox cboNetwork,cboGame,cboBall,cboBuy;//复选框
    private JTextArea txtNote;//多行文本框
    private JScrollPane scoNote;//滚动面板
    private JButton btnSubmit,btnExit;
    //构造方法
    public UserRegister(){
        //实例化控件
        mainPanel=new JPanel(null);
        lblNo=new JLabel("学号");
        lblName=new JLabel("姓名");
        lblSex=new JLabel("性别");
        lblAge=new JLabel("年龄");
        lblCls=new JLabel("班级");
        lblHobby=new JLabel("爱好");
        lblNote=new JLabel("个人简介");
        txtNo=new JTextField();
        txtName=new JTextField();
        txtAge=new JTextField();
        rdoSexMan=new JRadioButton("男");
        rdoSexWoman=new JRadioButton("女");
        bg=new ButtonGroup();
        String[] cls={"软件18-1","软件18-2","软件18-3","软件19-1","软件19-2","软件19-3"};
        cboCls=new JComboBox<String>(cls);
        cboBall=new JCheckBox("篮球");
        cboBuy=new JCheckBox("购物");
        cboGame=new JCheckBox("游戏");
        cboNetwork=new JCheckBox("上网");
        txtNote=new JTextArea();
        scoNote=new JScrollPane(txtNote);
        btnSubmit = new JButton("提交");
        btnExit = new JButton("退出");

        //监控按钮
        btnSubmit.addActionListener(this);
        btnExit.addActionListener(this);

        //设置控件的位置和大小
        lblNo.setBounds(30,30,60,25);
        txtNo.setBounds(90,30,250,25);
        lblName.setBounds(30,65,60,25);
        txtName.setBounds(90,65,250,25);
        lblAge.setBounds(30,100,60,25);
        txtAge.setBounds(90,100,250,25);
        lblSex.setBounds(30,135,60,25);
        rdoSexMan.setBounds(90,135,60,25);
        rdoSexWoman.setBounds(180,135,60,25);
        bg.add(rdoSexMan);
        bg.add(rdoSexWoman);//互斥
        lblCls.setBounds(30,170,60,25);
        cboCls.setBounds(90,170,250,25);
        lblHobby.setBounds(30,205,60,25);
        cboBall.setBounds(90,205,60,25);
        cboBuy.setBounds(150,205,60,25);
        cboGame.setBounds(210,205,60,25);
        cboNetwork.setBounds(270,205,60,25);
        lblNote.setBounds(30,240,60,25);
        scoNote.setBounds(90,240,250,100);
        this.setBounds(700,350,370,430);
        btnSubmit.setBounds(100,350,60,30);
        btnExit.setBounds(250,350,60,30);
        //将控件放入容器
        setContentPane(mainPanel);
        mainPanel.add(lblAge);
        mainPanel.add(lblCls);
        mainPanel.add(lblHobby);
        mainPanel.add(lblName);
        mainPanel.add(lblNo);
        mainPanel.add(lblNote);
        mainPanel.add(lblSex);
        mainPanel.add(txtAge);
        mainPanel.add(txtName);
        mainPanel.add(txtNo);
        mainPanel.add(scoNote);
        mainPanel.add(rdoSexMan);
        mainPanel.add(rdoSexWoman);
        mainPanel.add(cboCls);
        mainPanel.add(cboBall);
        mainPanel.add(cboBuy);
        mainPanel.add(cboGame);
        mainPanel.add(cboNetwork);
        mainPanel.add(btnSubmit);
        mainPanel.add(btnExit);
        //设置窗口的属性
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        new UserRegister();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnSubmit)){
            String s,no,name,age,sex,cls,likes,Introduction;
            Introduction = "";
            s = "";
            likes = "";
            //获取文本框内容
            no = txtNo.getText();
            name = txtName.getText();
            age = txtAge.getText();

            //获取性别
            if(rdoSexMan.isSelected()){
                sex="男";
            }
            else{
                sex="女";
            }
            //获取班级
            cls = cboCls.getSelectedItem().toString();

            //获取爱好
            if(cboBall.isSelected()){
                likes += cboBall.getText() + "\t";
            }
            if(cboBuy.isSelected()){
                likes += cboBuy.getText() + "\t";
            }
            if(cboGame.isSelected()){
                likes += cboGame.getText() + "\t";
            }
            if(cboNetwork.isSelected()){
                likes += cboNetwork.getText() + "\t";
            }
            if(likes == ""){
                likes = "无";
            }

            //获取简介
            Introduction = txtNote.getText();

            if(Introduction == ""){
                likes = "无";
            }

            s = "学号：" + no + "\n" + "姓名：" + name + "\n" + "年龄：" + age + "\n" + "性别：" + sex + "\n" + "班级：" + cls + "\n" + "爱好：" + likes + "\n" + "个人简介：" + Introduction;

            JOptionPane.showMessageDialog(null, s, "个人信息", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getActionCommand().equals("退出")){
            System.exit(0);
        }
    }
}