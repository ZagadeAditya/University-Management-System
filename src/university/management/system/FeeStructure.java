package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    FeeStructure() {

        setLocation(250, 50);
        setSize(1000, 700);
        setLayout(null);

        JLabel heading = new JLabel("Fee Structure:");
        heading.setBounds(50, 50, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JTable table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 100, 900, 600);
        add(jsp);

        setVisible(true);
    }

    public static void main(String args[]) {
        new FeeStructure();
    }
}
