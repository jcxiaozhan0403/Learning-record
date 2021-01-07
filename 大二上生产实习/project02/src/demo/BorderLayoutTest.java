package demo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
    JButton northbtn = new JButton("北边的按钮");
    JLabel southLabel = new JLabel("南边的label");
    JRadioButton westRadioBtn = new JRadioButton("男");
    JTextArea east = new JTextArea("输入内容",10,20);
    JButton center = new JButton("中间的按钮");

    public BorderLayoutTest(){
        super("边界布局");

        //单独设置组件大小,0表示默认
        westRadioBtn.setPreferredSize(new Dimension(70,0));

        //添加组件到面板
        Container container = getContentPane();
        container.add(northbtn,BorderLayout.NORTH);
        container.add(southLabel,BorderLayout.SOUTH);
        container.add(westRadioBtn,BorderLayout.WEST);
        container.add(east,BorderLayout.EAST);
        container.add(center,BorderLayout.CENTER);

        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}
