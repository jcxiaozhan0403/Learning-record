package view;

import sqlConnection.Test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    private JLabel lblTitle,lblUserId,lblUserPwd;
    private JTextField txtUserId;
    private JPasswordField txtUserPwd;
    private JButton btnLogin,btnExit;
    private JPanel mainPanel;
    public Login(){
        super("酒店管理系统");
        mainPanel=new JPanel(null);
        lblTitle=new JLabel("酒店管理系统",JLabel.CENTER);
        lblUserId=new JLabel("工号",JLabel.RIGHT);
        lblUserPwd=new JLabel("密码",JLabel.RIGHT);
        txtUserId=new JTextField();
        txtUserPwd=new JPasswordField();
        btnLogin=new JButton("登录");
        btnExit=new JButton("退出");

        //设置位置和大小
        lblTitle.setBounds(105,30,200,50);
        lblUserId.setBounds(35,100,75,25);
        txtUserId.setBounds(115,100,200,25);
        lblUserPwd.setBounds(35,145,75,25);
        txtUserPwd.setBounds(115,145,200,25);
        btnLogin.setBounds(130,190,60,25);
        btnExit.setBounds(230,190,60,25);

        //将控件放入容器
        setContentPane(mainPanel);
        mainPanel.add(lblTitle);
        mainPanel.add(lblUserId);
        mainPanel.add(lblUserPwd);
        mainPanel.add(txtUserId);
        mainPanel.add(txtUserPwd);
        mainPanel.add(btnExit);
        mainPanel.add(btnLogin);

        //字体
        lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 25));

        //事件监听
        btnExit.addActionListener(this);
        btnLogin.addActionListener(this);

        //设置窗口
        setSize(425,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }


    //判断登录退出按钮
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnExit)){
            System.exit(0);
        }
        if(e.getSource().equals(btnLogin)){
            try {
                userLogin();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    //登录功能
    private void userLogin() throws Exception {
        //密码转字符串
        char[] ps=txtUserPwd.getPassword();
        String pwd = new String(ps);

        Test a = new Test();
        boolean flag = a.sss(txtUserId.getText(),pwd);

        if (flag){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
