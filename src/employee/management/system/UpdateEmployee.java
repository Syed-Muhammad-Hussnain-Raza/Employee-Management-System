package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JLabel lblName, lblFatherName, lblDateOfBirthDate, lblAadhar, lblEmpId;
    JTextField salaryTextField, addressTextField, phoneTextField, emailTextField, educationTextField, designationTextField;
    JButton updateEmployee, back;
    String empId;
    // Constructor
    public UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN-SERIF", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 30);
        nameLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(nameLabel);

        lblName = new JLabel();
        lblName.setBounds(200, 150, 150, 30);
        add(lblName);

        // Father Name
        JLabel fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(400, 150, 150, 30);
        fatherNameLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(fatherNameLabel);

        lblFatherName = new JLabel();
        lblFatherName.setBounds(600, 150, 150, 30);
        add(lblFatherName);

        // Date of Birth
        JLabel dateOfBirthLabel = new JLabel("Date of Birth");
        dateOfBirthLabel.setBounds(50, 200, 150, 30);
        dateOfBirthLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(dateOfBirthLabel);

        lblDateOfBirthDate = new JLabel();
        lblDateOfBirthDate.setBounds(200, 200, 150, 30);
        add(lblDateOfBirthDate);

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

        educationTextField = new JTextField();
        educationTextField.setBounds(600, 300, 150, 30);
        add(educationTextField);

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

        lblAadhar = new JLabel();
        lblAadhar.setBounds(600, 350, 150, 30);
        add(lblAadhar);

        // Employee ID
        JLabel employeeIDLabel = new JLabel("Emp. ID");
        employeeIDLabel.setBounds(50, 400, 150, 30);
        employeeIDLabel.setFont(new Font("serif", Font.PLAIN ,20));
        add(employeeIDLabel);

        lblEmpId = new JLabel();
        lblEmpId.setBounds(200, 400, 150, 30);
        add(lblEmpId);

        // MySQL
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblName.setText(rs.getString("name"));
                lblFatherName.setText(rs.getString("fname"));
                lblDateOfBirthDate.setText(rs.getString("dob"));
                salaryTextField.setText(rs.getString("salary"));
                addressTextField.setText(rs.getString("address"));
                phoneTextField.setText(rs.getString("phone"));
                emailTextField.setText(rs.getString("email"));
                educationTextField.setText(rs.getString("education"));
                designationTextField.setText(rs.getString("designation"));
                lblAadhar.setText(rs.getString("aadhar"));
                lblEmpId.setText(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons
        updateEmployee = new JButton("Update Details");
        updateEmployee.setBounds(250, 550, 150, 40);
        updateEmployee.setBackground(Color.BLACK);
        updateEmployee.setForeground(Color.WHITE);
        updateEmployee.addActionListener(this);
        add(updateEmployee);

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
        if (ae.getSource() == updateEmployee) {
            String salary = salaryTextField.getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String education = educationTextField.getText();
            String designation = designationTextField.getText();

            try {
                Conn conn = new Conn();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
}