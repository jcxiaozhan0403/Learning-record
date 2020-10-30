package txt;

import java.awt.BorderLayout;

import javax.swing.*;

public class NoteEdit extends JFrame{
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menuFile,menuEdit,menuHelp;
    private JMenuItem newItem,openItem,saveItem,exitItem,copyItem,
            cutItem,pasteItem,fontItem,colorItem,aboutItem;
    private JToolBar toolBar;
    private JButton btnNew,btnOpen,btnSave,btnCut,btnCopy,btnPaste,btnFont,btnColor;
    private JTextArea txtArea;
    private JScrollPane scrollPane;
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

        ImageIcon newIcon=new ImageIcon(NoteEdit.class.getClassLoader().getResource("img//new.png"));
        btnNew=new JButton(newIcon);
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
        //设置窗口属性
        setVisible(true);
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new NoteEdit();
    }
}