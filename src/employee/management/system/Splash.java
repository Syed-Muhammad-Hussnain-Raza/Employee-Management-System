package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    public Splash() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2  = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton clickHere = new JButton("Click Here To Continue");
        clickHere.setBounds(400, 400, 300, 70);
        clickHere.setBackground(Color.BLACK);
        clickHere.setForeground(Color.WHITE);
        clickHere.addActionListener(this);
        image.add(clickHere);

        setSize(1170, 650);
        setVisible(true);
        setLocation(150, 50);

        while (true) {
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}