package demo;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class Test1 extends JFrame{
    JButton jButton;

    public Test1(){
        super("学生成绩管理系统");

        jButton = new JButton("按钮");
        Container connection = getContentPane();
        connection.add(jButton);

        setSize(600,400);

        //居中
        setLocationRelativeTo(null);

        //图标
        URL resource = null;
        try {
            resource = new URL("https://img.jcxiaozhan.top/%E7%BD%91%E7%AB%99%E5%B0%8F%E5%9B%BE%E6%A0%87.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image logo = new ImageIcon(resource).getImage();
        setIconImage(logo);

        //不可改变窗体大小
        setResizable(false);

        //关闭窗口退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //窗体可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test1();
    }
}
