package txt;

import javax.swing.*;

public class myFont extends JDialog {
    private JPanel mainPanel;
    private JLabel lblZt,lblZx,lblDx;
    private JList<String> listZt,listZx,listDx;
    private JButton btnOk,btnCancel;
    public myFont(JFrame frame){
        super(frame,"设置字体",true);
        mainPanel = new JPanel(null);
        lblZt = new JLabel("字体");
        lblZx = new JLabel("字形");
        lblDx = new JLabel("大小");
        listZt = new JList<String>();
    }
}
