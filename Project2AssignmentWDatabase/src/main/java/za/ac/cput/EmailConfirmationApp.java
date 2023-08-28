package za.ac.cput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;


/**
 * EmailConfirmationApp.java
 * 222401680
 * @author Moegammad Nur Johnston
 * 2023/08/20
 */
public class EmailConfirmationApp extends JFrame implements ActionListener {

    private JComboBox<String> courseComboBox;
    private JComboBox<String> universityComboBox;
    private JButton confirmButton;
    private JLabel infoLabel;
    private int applicationCount;

    public EmailConfirmationApp() {
        setTitle("Application Confirmation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.BLUE);
        upperPanel.setLayout(new BorderLayout());

        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(Color.BLUE);
        middlePanel.setLayout(new GridLayout(4, 1, 10, 10));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] courses = {"Accounting", "Commerce", "Computer Science (IT)", "Engineering", "Law"};
        courseComboBox = new JComboBox<>(courses);
        JPanel coursePanel = new JPanel();
        coursePanel.add(new JLabel("Select a course:"));
        coursePanel.add(courseComboBox);
        middlePanel.add(coursePanel);

        String[] universities = {"CPUT", "Stellies", "UCT", "UWC", "Wits"};
        universityComboBox = new JComboBox<>(universities);
        JPanel universityPanel = new JPanel();
        universityPanel.add(new JLabel("Select a university:"));
        universityPanel.add(universityComboBox);
        middlePanel.add(universityPanel);

        JPanel warningPanel = new JPanel();
        warningPanel.add(new JLabel("Warning: Each time the Confirm button is pressed, an application has been made. "
                + "you are allowed 3 applications)"));
        middlePanel.add(warningPanel);

        confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.GREEN);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        middlePanel.add(buttonPanel);

        upperPanel.add(middlePanel, BorderLayout.CENTER);

        setContentPane(upperPanel);

        applicationCount = 0;

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == confirmButton) {
        String selectedCourse = (String) courseComboBox.getSelectedItem();
        String selectedUniversity = (String) universityComboBox.getSelectedItem();

        if (selectedCourse != null && selectedUniversity != null) {
            ApplicationWorker worker = new ApplicationWorker();
            worker.processApplication(selectedCourse, selectedUniversity, applicationCount);

            applicationCount++;
        }
    }
}

}
