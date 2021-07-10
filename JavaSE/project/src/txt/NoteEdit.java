package txt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class NoteEdit extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menuFile,menuEdit,menuHelp;
    private JMenuItem newItem,openItem,saveItem,exitItem,copyItem,
            cutItem,pasteItem,fontItem,colorItem,aboutItem;
    private JToolBar toolBar;
    private JButton btnNew,btnOpen,btnSave,btnCut,btnCopy,btnPaste,btnFont,btnColor;
    private JTextArea txtArea;
    private JScrollPane scrollPane;
    private String fileName = "新文件";
    private static int count = 0;
    public NoteEdit(){
        //实例化控件
        mainPanel=new JPanel(new BorderLayout());//采用边界布局
        menuBar=new JMenuBar();
        menuFile=new JMenu("文件");
        menuEdit=new JMenu("编辑");
        menuHelp=new JMenu("帮助");
        newItem=new JMenuItem("新建");
        openItem=new JMenuItem("打开");
        saveItem=new JMenuItem("保存");
        exitItem=new JMenuItem("退出");
        cutItem=new JMenuItem("剪切");
        copyItem=new JMenuItem("复制");
        pasteItem=new JMenuItem("粘贴");
        fontItem=new JMenuItem("字体");
        colorItem=new JMenuItem("颜色");
        aboutItem=new JMenuItem("关于");
        toolBar=new JToolBar();
        btnColor=new JButton("颜色");
        btnCopy=new JButton("复制");
        btnCut=new JButton("剪切");
        btnFont=new JButton("字体");

//        ImageIcon newIcon=new ImageIcon(NoteEdit.class.getClassLoader().getResource("img//new.png"));
        btnNew=new JButton("新建");
        btnOpen=new JButton("打开");
        btnPaste=new JButton("粘贴");
        btnSave=new JButton("保存");
        txtArea=new JTextArea();
        scrollPane=new JScrollPane(txtArea);
        //将控件放入容器
        setContentPane(mainPanel);
        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.addSeparator();
        menuFile.add(saveItem);
        menuFile.addSeparator();
        menuFile.add(exitItem);
        menuEdit.add(cutItem);
        menuEdit.add(copyItem);
        menuEdit.add(pasteItem);
        menuEdit.addSeparator();
        menuEdit.add(fontItem);
        menuEdit.add(colorItem);
        menuHelp.add(aboutItem);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);
        toolBar.add(btnNew);
        toolBar.add(btnOpen);
        toolBar.add(btnSave);
        toolBar.addSeparator();
        toolBar.add(btnCut);
        toolBar.add(btnCopy);
        toolBar.add(btnPaste);
        toolBar.addSeparator();
        toolBar.add(btnFont);
        toolBar.add(btnColor);
        mainPanel.add(toolBar,"North");
        mainPanel.add(scrollPane,"Center");

        //监听
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        fontItem.addActionListener(this);
        colorItem.addActionListener(this);
        aboutItem.addActionListener(this);
        btnNew.addActionListener(this);
        btnOpen.addActionListener(this);
        btnSave.addActionListener(this);
        btnCut.addActionListener(this);
        btnCopy.addActionListener(this);
        btnPaste.addActionListener(this);
        btnFont.addActionListener(this);
        btnColor.addActionListener(this);

        //设置窗口属性
        setTitle(fileName);
        setVisible(true);
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new NoteEdit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(exitItem)){
            System.exit(0);
        }
        if (e.getSource().equals(newItem) || e.getSource().equals(btnNew)){
            txtArea.setText("");
            count++;
            setTitle(fileName + count);
        }
        if (e.getSource().equals(openItem) || e.getSource().equals(btnOpen)){
            try {
                open();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource().equals(saveItem) || e.getSource().equals(btnSave)){
            try {
                save();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource().equals(cutItem) || e.getSource().equals(btnCut)){
            txtArea.cut();
        }
        if (e.getSource().equals(copyItem) || e.getSource().equals(btnCopy)){
            txtArea.copy();
        }
        if (e.getSource().equals(pasteItem) || e.getSource().equals(btnPaste)){
            txtArea.paste();
        }
        if (e.getSource().equals(colorItem) || e.getSource().equals(btnColor)){
            txtArea.setForeground(getColor());
        }
    }

    private Color getColor() {
        JColorChooser cc = new JColorChooser();
        Color c =cc.showDialog(this,"颜色设置",Color.black);
        return c;
    }

    private void open() throws IOException {
        JFileChooser fc = new JFileChooser("c:\\");
        int n = fc.showOpenDialog(this);
        if(n == 0){
            setTitle(fc.getSelectedFile().getName());
            File file = fc.getSelectedFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            int n1 = 0;
            char[]cs = new char[1024];
            while((n1 = br.read(cs)) != -1){
                sb.append(new String(cs,0,n1));
            }
            txtArea.setText(sb.toString());
            br.close();
            fr.close();
        }
    }

    private void save() throws IOException {
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == 0){
            File file = fc.getSelectedFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(txtArea.getText());
            bw.close();
            fw.close();
        }
    }
}