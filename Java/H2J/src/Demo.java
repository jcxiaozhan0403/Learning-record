import javax.swing.*;
import java.awt.*;

public class Demo {
    public static class TestGUI extends JFrame {
        public static void main(String[] args) {
            // 主窗体
            JFrame f = new JFrame("加速器");

            // 主窗体设置大小
            f.setSize(100, 100);

            // 主窗体设置位置
            f.setLocation(200, 200);

            // 主窗体中的组件设置为绝对定位
            f.setLayout(new FlowLayout());

            // 按钮组件
            JButton b = new JButton("求和");


            // 同时设置组件的大小和位置
            b.setBounds(50, 50, 280, 30);
            b.setBounds(50, 50, 280, 30);
            b.setBounds(50, 50, 280, 30);
            b.setBounds(50, 50, 280, 30);
            b.setBounds(50, 50, 280, 30);
            b.setBounds(50, 50, 280, 30);

            // 把按钮加入到主窗体中
            f.add(b);

            // 关闭窗体的时候，退出程序
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 让窗体变得可见
            f.setVisible(true);

        }
    }
}