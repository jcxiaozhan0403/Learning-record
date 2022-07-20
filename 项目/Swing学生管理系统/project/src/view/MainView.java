package view;

import dao.StudentDao;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class MainView extends JFrame implements ActionListener {
    MainView mainView = null;
    public static JTable jTable;
    private JComboBox<String> cboCls;//下拉框
    JTextField findTxt = new JTextField();
    JButton addBtn = new JButton("添加");
    JButton delBtn = new JButton("删除");
    JButton alterBtn = new JButton("修改");
    JButton findBtn = new JButton("查询");
    JPanel centerPanel = new JPanel();
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    static view.StudentTableModel studentTableModel;

    public MainView() {
        super("学生信息管理系统");

        String[] cls={"学号","姓名","性别","年龄","班级"};
        cboCls=new JComboBox<String>(cls);

        findTxt.setPreferredSize(new Dimension(80,25));

        //添加三个按钮到北面板
        Container container = getContentPane();
        northPanel.add(addBtn);
        northPanel.add(delBtn);
        northPanel.add(alterBtn);
        northPanel.add(cboCls);
        northPanel.add(findTxt);
        northPanel.add(findBtn);

        container.add(northPanel,BorderLayout.NORTH);
        container.add(centerPanel,BorderLayout.CENTER);

        //按钮添加事件监听
        addBtn.addActionListener(this);
        delBtn.addActionListener(this);
        alterBtn.addActionListener(this);
        findBtn.addActionListener(this);

        //Logo
        URL resource = null;
        try {
            resource = new URL("https://ae04.alicdn.com/kf/H7b8cfb6daf46406987f4d146858be65fB.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image img = new ImageIcon(resource).getImage();
        setIconImage(img);

        loadTableData();
        // jtable和table关联
        jTable = new JTable(studentTableModel);


        // 设置表头
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font(null,Font.BOLD,16));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setReorderingAllowed(false);
        // 设置表格体
        jTable.setFont(new Font(null,Font.PLAIN,14));
        jTable.setForeground(Color.BLACK);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(25);

        // 设置表格列的渲染方式
        tableStyle();

        Container contentPane = getContentPane();
        // jtable放在jpanel上的话，默认是不展示列头的，需要特殊设置。放在JScrollPane上面
        // 默认是展示列头的
        JScrollPane jScrollPane = new JScrollPane(jTable);
        contentPane.add(jScrollPane);

        setSize(720,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void tableStyle() {
        Vector<String> columns = StudentTableModel.getColumns();
        StudentCellRender render = new StudentCellRender();
        for (int i =0;i < columns.size();i++) {
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(render);
            column.setResizable(false);
        }
    }

    /* */
    public static void loadTableData(){

        Vector<Vector<Object>> data = null;
        try {
            data = StudentDao.query();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // tablemodel:和jtable关联后，之后只需要更新model就能把数据的变化反应到jtable中
        studentTableModel = view.StudentTableModel.assembleModel(data);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addBtn)){
            new AddFrame(mainView);
        }else if (e.getSource().equals(delBtn)){
            try {
                StudentDao.del();
                loadTableData();
                tableStyle();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(mainView,"请选中需要删除的数据");
            }
        }else if (e.getSource().equals(alterBtn)){
            try {
                int count= MainView.jTable.getSelectedRow();//获取你选中的行号（记录）
                String stuId = MainView.jTable.getValueAt(count, 0).toString();
                String stuName = MainView.jTable.getValueAt(count, 1).toString();
                String stuSex = MainView.jTable.getValueAt(count, 2).toString();
                int stuAge = Integer.parseInt(MainView.jTable.getValueAt(count, 3).toString());
                String stuCls = MainView.jTable.getValueAt(count, 4).toString();

                new ModifyFrame(stuId,stuName,stuSex,stuAge,stuCls,mainView);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(mainView,"请选中需要修改的数据");
            }
        }else if (e.getSource().equals(findBtn)){
            String key = cboCls.getSelectedItem().toString();
            String val = findTxt.getText();
            String sql = null;

            switch (key){
                case "学号": sql = "select * from student where stuId = ?";
                    break;
                case "姓名": sql = "select * from student where stuName = ?";
                    break;
                case "性别": sql = "select * from student where stuSex = ?";
                    break;
                case "年龄": sql = "select * from student where stuAge = ?";
                    break;
                case "班级": sql = "select * from student where stuCls = ?";
                    break;
            }
            try {
                Vector<Vector<Object>> data = null;
                try {
                    data = StudentDao.find(val,sql);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                // tablemodel:和jtable关联后，之后只需要更新model就能把数据的变化反应到jtable中
                studentTableModel = view.StudentTableModel.assembleModel(data);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(mainView,"查询为空");
            }
            tableStyle();
        }
    }
}
class StudentCellRender extends DefaultTableCellRenderer {
    // 在每一行的每一列显示之前都会调用
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.WHITE);

        //单元格内容水平居中
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

// 自定义tablemodel
class StudentTableModel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("学号");
        columns.addElement("姓名");
        columns.addElement("性别");
        columns.addElement("年龄");
        columns.addElement("班级");
    }

    private StudentTableModel() {
        super(null,columns);
    }

    private static view.StudentTableModel studentTableModel = new view.StudentTableModel();

    public static view.StudentTableModel assembleModel(Vector<Vector<Object>> data) {
        studentTableModel.setDataVector(data,columns);
        return studentTableModel;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
