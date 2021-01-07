package demo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FlowLayoutTest extends JFrame {
    //JPanel的默认布局方式是流布局
    //JPanel jPanel = new JPanel();
    //JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,80,30));
    //FlowLayout(对齐方式，水平间距，垂直间距)
    JPanel jPanel = new JPanel(new FlowLayout());
    JButton btn1 = new JButton("按钮1");
    JButton btn2 = new JButton("按钮2");
    JButton btn3 = new JButton("按钮3");
    JButton btn4 = new JButton("按钮4");
    JButton btn5 = new JButton("按钮5");
    JButton btn6 = new JButton("按钮6");
    JButton btn7 = new JButton("按钮7");
    JButton btn8 = new JButton("按钮8");
    JButton btn9 = new JButton("按钮9");

    public FlowLayoutTest() {
        super("边界布局");

        Container container = getContentPane();
        container.add(jPanel);

        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}