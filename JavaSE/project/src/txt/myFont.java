package txt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class myFont extends JDialog implements ActionListener {
    private JPanel mainPanel;
    private JLabel lblZt,lblZx,lblDx;
    private JComboBox<String> listZt,listZx,listDx;
    private JButton btnOk,btnCancel;
    private Font font;
    public void MyFont(JFrame frame){
//        super(frame,"设置字体",true);
        mainPanel=new JPanel(null);
        lblZt=new JLabel("字体：");
        lblZx=new JLabel("字形：");
        lblDx=new JLabel("大小");
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = e.getAvailableFontFamilyNames();
        listZt=new JComboBox<String>(fontNames);
        String[] zx={"常规","倾斜","加粗"};
        listZx=new JComboBox<String>(zx);
        String[] dx={"6","7","8","10","14","20","30"};
        listDx=new JComboBox<String>(dx);
        btnOk=new JButton("确定");
        btnCancel=new JButton("取消");
        //
        listZx.setMaximumRowCount(10);
        ///设置大小和位置
        lblZt.setBounds(20,20,80,25);
        lblZx.setBounds(140,20,80,25);
        lblDx.setBounds(260,20,80,25);
        listZt.setBounds(20,50,100,25);
        listZx.setBounds(140,50,100,25);
        listDx.setBounds(260,50,100,25);
        btnOk.setBounds(190,170,60,25);
        btnCancel.setBounds(300,170,60,25);
        ///把控件放入容器
        setContentPane(mainPanel);
        mainPanel.add(lblDx);
        mainPanel.add(lblZt);
        mainPanel.add(lblZx);
        mainPanel.add(listZt);
        mainPanel.add(listZx);
        mainPanel.add(listDx);
        mainPanel.add(btnOk);
        mainPanel.add(btnCancel);
        //
        btnOk.addActionListener(this);
        btnCancel.addActionListener(this);
        //设置窗口
        setBounds(100,100,380,250);
        //setVisible(true);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnCancel)){
            this.setVisible(false);
        }
        if(e.getSource().equals(btnOk)){
            String fontName=listZt.getSelectedItem().toString();
            int n=0;
            if(listZx.getSelectedItem().toString().equals("常规")){
                n=Font.PLAIN;
            }
            if(listZx.getSelectedItem().toString().equals("加粗")){
                n=Font.BOLD;
            }
            if(listZx.getSelectedItem().toString().equals("倾斜")){
                n=Font.ITALIC;
            }
            int zh=Integer.valueOf(listDx.getSelectedItem().toString());
            font=new Font(fontName,n,zh);
            this.setVisible(false);
        }
    }
    public Font getMyFont(){
        return font;
    }

}
