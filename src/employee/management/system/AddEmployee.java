package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    JLabel employeeID;
    JTextField nameTextField, fatherNameTextField, salaryTextField, addressTextField,
            phoneTextField, emailTextField, designationTextField, aadharTextField;
    JDateChooser dateOfBirthDateChooser;
    JComboBox educationComboBox;
    JButton addEmployee, back;

    Random ran = new Random();
    int number  =  ran.nextInt(999999);
    public AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel headings = new JLabel("Add Employee Details");
        headings.setBounds(320, 30, 500, 50);
        headings.setFont(new Font("SAN-SERIF", Font.BOLD, 25));
        add(headings);

        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 30);
        nameLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(200, 150, 150, 30);
        add(nameTextField);

        // Father Name
        JLabel fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(400, 150, 150, 30);
        fatherNameLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(fatherNameLabel);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(600, 150, 150, 30);
        add(fatherNameTextField);

        // Date of Birth
        JLabel dateOfBirthLabel = new JLabel("Date of Birth");
        dateOfBirthLabel.setBounds(50, 200, 150, 30);
        dateOfBirthLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(dateOfBirthLabel);

        dateOfBirthDateChooser = new JDateChooser();
        dateOfBirthDateChooser.setBounds(200, 200, 150, 30);
        add(dateOfBirthDateChooser);

        // Salary
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400, 200, 150, 30);
        salaryLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(salaryLabel);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(600, 200, 150, 30);
        add(salaryTextField);

        // Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 150, 30);
        addressLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setBounds(200, 250, 150, 30);
        add(addressTextField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400, 250, 150, 30);
        phoneLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(600, 250, 150, 30);
        add(phoneTextField);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 300, 150, 30);
        emailLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(200, 300, 150, 30);
        add(emailTextField);

        // Education
        JLabel educationLabel = new JLabel("Education");
        educationLabel.setBounds(400, 300, 150, 30);
        educationLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(educationLabel);
        String[] courses = {"BCS", "BSE", "BBA", "BPH", "BA", "B.COM", "MBA", "M.Tech", "MCS", "PHD"};

        educationComboBox = new JComboBox(courses);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setBounds(600, 300, 150, 30);
        add(educationComboBox);

        // Designation
        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50, 350, 150, 30);
        designationLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(designationLabel);

        designationTextField = new JTextField();
        designationTextField.setBounds(200, 350, 150, 30);
        add(designationTextField);

        // Aadhar
        JLabel aadharLabel = new JLabel("Aadhar");
        aadharLabel.setBounds(400, 350, 150, 30);
        aadharLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(600, 350, 150, 30);
        add(aadharTextField);

        // Employee ID
        JLabel employeeIDLabel = new JLabel("Emp. ID");
        employeeIDLabel.setBounds(50, 400, 150, 30);
        employeeIDLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(employeeIDLabel);

        employeeID = new JLabel("" + number);
        employeeID.setBounds(200, 400, 150, 30);
        add(employeeID);

        // Buttons
        addEmployee = new JButton("Add Details");
        addEmployee.setBounds(250, 550, 150, 40);
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        add(addEmployee);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addEmployee) {
            String name = nameTextField.getText();
            String fatherName = fatherNameTextField.getText();
            String dob = ((JTextField) dateOfBirthDateChooser.getDateEditor().getUiComponent()).getText();
            String salary = salaryTextField.getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String education =  (String) educationComboBox.getSelectedItem();
            String designation = designationTextField.getText();
            String aadhar = aadharTextField.getText();
            String empId = employeeID.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into  employee values('"+name+"', '"+fatherName+"', '"+ dob+"'," +
                        "'"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+
                        "','"+designation+ "', '"+aadhar+"', '"+empId+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            }catch(Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }
}