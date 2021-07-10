package abc;

import java.awt.Point;

import javax.swing.JFrame;

public class Test1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("我的电脑");
        frame.setSize(400,300);
        frame.setLocation(new Point(200,200));
        frame.setVisible(true);
    }
}
