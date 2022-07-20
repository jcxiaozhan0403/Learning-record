package view;

import handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginView extends JFrame{
    JLabel title = new JLabel("学生信息管理系统",JLabel.CENTER);
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userNameLabel = new JLabel("用户名:");
    JLabel pwdLabel = new JLabel("密  码:");
    JTextField userTxt = new JTextField();
    JPasswordField pwdField = new JPasswordField();
    JButton loginBtn = new JButton("登录");
    JButton resetBtn = new JButton("重置");

    LoginHandler loginHandler;
    public LoginView() {
        super("登录");

        loginHandler = new LoginHandler(this);

        title.setFont(new Font("华文行楷",Font.PLAIN,40));
        title.setPreferredSize(new Dimension(0,80));

        Font centerFont = new Font("楷体",Font.PLAIN,20);

        userNameLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);
        userTxt.setPreferredSize(new Dimension(200,30));
        pwdField.setPreferredSize(new Dimension(200,30));

        Container container = getContentPane();
        centerPanel.add(userNameLabel);
        centerPanel.add(pwdLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdField);
        loginBtn.addKeyListener(loginHandler);
        loginBtn.addActionListener(loginHandler);
        resetBtn.addActionListener(loginHandler);
        centerPanel.add(loginBtn);
        centerPanel.add(resetBtn);

        //弹簧布局
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel),Spring.width(userTxt)),Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;

        //设置参照组件位置
        springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,centerPanel);
        //userNameLabel
        springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,40,SpringLayout.NORTH,centerPanel);

        //userTxt
        springLayout.putConstraint(SpringLayout.WEST,userTxt,30,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,userTxt,0,SpringLayout.NORTH,userNameLabel);
        //pwdLabel
        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0,SpringLayout.EAST,userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdLabel,30,SpringLayout.SOUTH,userNameLabel);
        //pwdField
        springLayout.putConstraint(SpringLayout.WEST,pwdField,30,SpringLayout.EAST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,pwdField,0,SpringLayout.NORTH,pwdLabel);
        //loginBtn
        springLayout.putConstraint(SpringLayout.WEST,loginBtn,0,SpringLayout.WEST,pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH,loginBtn,50,SpringLayout.SOUTH,pwdLabel);
        //resetBtn
        springLayout.putConstraint(SpringLayout.EAST,resetBtn,0,SpringLayout.EAST,pwdField);
        springLayout.putConstraint(SpringLayout.NORTH,resetBtn,0,SpringLayout.NORTH,loginBtn);

        //Logo
        URL resource = null;
        try {
            resource = new URL("https://ae04.alicdn.com/kf/H7b8cfb6daf46406987f4d146858be65fB.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image img = new ImageIcon(resource).getImage();
        setIconImage(img);

        //设置loginBtn为默认按钮
        getRootPane().setDefaultButton(loginBtn);

        container.add(centerPanel,BorderLayout.CENTER);
        container.add(title,BorderLayout.NORTH);



        setSize(600,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public JTextField getUserTxt() {
        return userTxt;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }
}
