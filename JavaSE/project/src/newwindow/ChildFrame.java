package newwindow;

import javax.swing.*;

public class ChildFrame extends JInternalFrame {
    public ChildFrame(){
        super("子窗口",false,true,false,true);
        setBounds(100,100,300,200);
        setVisible(true);
    }
}
