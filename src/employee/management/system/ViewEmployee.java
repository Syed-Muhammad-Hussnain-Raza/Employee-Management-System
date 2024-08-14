package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cEmployeeId;
    JButton search, print, update, back;

    public ViewEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        cEmployeeId = new Choice();
        cEmployeeId.setBounds(180, 20, 150, 20);
        cEmployeeId.setBackground(Color.WHITE);
        add(cEmployeeId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                cEmployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch(Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        // Search Button
        this.search = new JButton("Search");
        this.search.setBounds(20, 70, 80, 20);
        this.search.addActionListener(this);
        add(this.search);

        // Print Button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // Update Button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        // Back Button
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "select * from employee where empId = '"+cEmployeeId.getSelectedItem()+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cEmployeeId.getSelectedItem());
        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

}