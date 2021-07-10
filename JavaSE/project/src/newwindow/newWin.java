package newwindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newWin extends JFrame implements ActionListener {
    private JDesktopPane desk;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newItem;
    public newWin(){
        desk=new JDesktopPane();
        menuBar=new JMenuBar();
        fileMenu=new JMenu("文件");
        newItem=new JMenuItem("新建");
        //将控件放入容器
        setContentPane(desk);
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(newItem);
        //监听
        newItem.addActionListener(this);
        //设置窗口属性
        setBounds(200,200,500,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new newWin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        desk.add(new ChildFrame());
    }
}
