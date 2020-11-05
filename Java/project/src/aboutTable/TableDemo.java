package aboutTable;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import java.awt.*;

public class TableDemo extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableColumnModel model;
    public TableDemo(){
        mainPanel = new JPanel(new BorderLayout());
        String[] heads = {"学号","姓名","性别","出生日期","家庭地址","联系方式"};
//        model = new DefaultTableColumnModel(heads,10);
//        table = new JTable(model);

    }
}
