package theDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class StudentList extends JFrame {
    private JPanel mainPanel;
    private JTable table;
    private JScrollPane js;
    private DefaultTableModel dm;
    public StudentList(){
        mainPanel = new JPanel(new BorderLayout());
        String [] headers = {"学号","姓名","性别","年龄"};
        dm = new DefaultTableModel(headers,0);
        table = new JTable(dm);
        js = new JScrollPane(table);

        //主面板
        setContentPane(mainPanel);
        mainPanel.add(js,"Center");

        //
        setBounds(200,200,500,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    private void fillData() throws SQLException {
        StudentDAO dao = new StudentDAO();
        List <Student> list = dao.findAll();

        Object[] objs = new Object[4];

        for (Student s : list){
            objs[0] = s.getStuId();
            objs[1] = s.getStuName();
            objs[2] = s.getStuSex();
            objs[3] = s.getStuAge();

            dm.addRow(objs);
        }
        SqlHelper.closeConn();
    }
}
