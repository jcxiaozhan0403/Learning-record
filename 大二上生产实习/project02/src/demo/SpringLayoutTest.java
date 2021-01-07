package demo;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutTest extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JLabel titleLabel = new JLabel("文章标题");
    JLabel authorLabel = new JLabel("作者");
    JLabel contLabel = new JLabel("请输入内容");
    JTextField titleText = new JTextField();
    JTextField authorText = new JTextField();
    JTextArea contArea = new JTextArea();



    public SpringLayoutTest() {
        super("弹性布局");

        jPanel.add(titleLabel);
        jPanel.add(authorLabel);
        jPanel.add(contLabel);
        titleText.setPreferredSize(new Dimension(200,20));
        jPanel.add(titleText);
        authorText.setPreferredSize(new Dimension(200,20));
        jPanel.add(authorText);
        contArea.setPreferredSize(new Dimension(200,20));
        jPanel.add(contArea);

        //标题文本框居中显示
        Spring titleLabelWidth = Spring.width(titleLabel);
        Spring titleTextWidth = Spring.width(titleText);
        Spring spaceWidth = Spring.constant(20);
        Spring childWidth = Spring.sum(Spring.sum(titleLabelWidth,titleTextWidth),spaceWidth);
        int offsetX = childWidth.getValue() / 2;


        //获取组件
        SpringLayout.Constraints titleLabelC = springLayout.getConstraints(titleLabel);
        //设置组件坐标
        springLayout.putConstraint(SpringLayout.WEST,titleLabel,-offsetX,SpringLayout.HORIZONTAL_CENTER,jPanel);
        //titleLabelC.setX(Spring.constant(100));
        titleLabelC.setY(Spring.constant(50));

        SpringLayout.Constraints titleTextC = springLayout.getConstraints(titleText);
        Spring titleLabelEastSpring = titleLabelC.getConstraint(SpringLayout.EAST);
        titleTextC.setConstraint(SpringLayout.WEST,Spring.sum(titleLabelEastSpring,Spring.constant(20)));
        titleTextC.setConstraint(SpringLayout.NORTH,titleLabelC.getConstraint(SpringLayout.NORTH));

        /*
        设置约束的第二种写法，相对简单
        e1:要设置组件的哪个边界( edgename)
        c1:要设置的组件
        pad:距离值
        e2:参照的组件的边界名
        c2:参考物（组件）
         */
        //设置authorLabel的东边和titleLabel对齐，北边距离titleLabel的南边20px
        springLayout.putConstraint(SpringLayout.EAST,authorLabel,0,SpringLayout.EAST,titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorLabel,20,SpringLayout.SOUTH,titleLabel);

        //设置authorText的西边距离authorLabel的东边20px，北边和authorLabel的北边对齐
        springLayout.putConstraint(SpringLayout.WEST,authorText,20,SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorText,0,SpringLayout.NORTH,authorLabel);

        //contLabel
        springLayout.putConstraint(SpringLayout.EAST,contLabel,0,SpringLayout.EAST,titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH,contLabel,20,SpringLayout.SOUTH,authorLabel);

        //contArea
        springLayout.putConstraint(SpringLayout.WEST,contArea,20,SpringLayout.EAST,contLabel);
        springLayout.putConstraint(SpringLayout.NORTH,contArea,0,SpringLayout.NORTH,contLabel);

        Container container = getContentPane();
        container.add(jPanel);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutTest();
    }
}
