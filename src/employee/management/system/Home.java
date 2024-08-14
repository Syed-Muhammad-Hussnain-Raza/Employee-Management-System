package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton addEmployee, viewEmployee, updateEmployee, removeEmployee;
    public Home() {
        setLayout(null);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2  = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel(" Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading) ;

        addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(650, 80, 150, 40);
        addEmployee.addActionListener(this);
        image.add(addEmployee);

        viewEmployee = new JButton("View Employees");
        viewEmployee.setBounds(820, 80, 150, 40);
        viewEmployee.addActionListener(this);
        image.add(viewEmployee);

        updateEmployee = new JButton("Update Employee");
        updateEmployee.setBounds(650, 140, 150, 40);
        updateEmployee.addActionListener(this);
        image.add(updateEmployee);

        removeEmployee = new JButton("Remove Employee");
        removeEmployee.setBounds(820, 140, 150, 40);
        removeEmployee.addActionListener(this);
        image.add(removeEmployee);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == addEmployee) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == viewEmployee) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == updateEmployee) {
            setVisible(false);
            // code here
        } else if (ae.getSource() == removeEmployee) {
            setVisible(false);
            // code here
        }
    }

}