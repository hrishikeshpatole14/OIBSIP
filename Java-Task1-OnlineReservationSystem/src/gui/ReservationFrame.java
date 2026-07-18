package gui;

import javax.swing.*;
import java.awt.*;
import service.ReservationService;

public class ReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField passengerField;
    JTextField trainNumberField;
    JTextField trainNameField;
    JTextField classField;
    JTextField dateField;
    JTextField sourceField;
    JTextField destinationField;
    JButton clearButton;

    JButton reserveButton;
    JButton backButton;

    public ReservationFrame() {

        setTitle("Online Reservation System - Reservation");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Passenger Name 
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Passenger Name"), gbc);

        gbc.gridx = 1;
        passengerField = new JTextField(20);
        panel.add(passengerField, gbc);

        // Train Number
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Train Number"), gbc);

        gbc.gridx = 1;
        trainNumberField = new JTextField(20);
        panel.add(trainNumberField, gbc);

        //Train Name 
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Train Name"), gbc);

        gbc.gridx = 1;
        trainNameField = new JTextField(20);
        panel.add(trainNameField, gbc);

        // ========= Class Type =========
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Class Type"), gbc);

        gbc.gridx = 1;
        classField = new JTextField(20);
        panel.add(classField, gbc);

        // ========= Journey Date =========
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Journey Date"), gbc);

        gbc.gridx = 1;
        dateField = new JTextField(20);
        panel.add(dateField, gbc);

        // ========= Source Station =========
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Source Station"), gbc);

        gbc.gridx = 1;
        sourceField = new JTextField(20);
        panel.add(sourceField, gbc);

        // ========= Destination Station =========
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Destination Station"), gbc);

        gbc.gridx = 1;
        destinationField = new JTextField(20);
        panel.add(destinationField, gbc);

        // ========= Buttons =========
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        reserveButton = new JButton("Reserve");
        reserveButton.setPreferredSize(new Dimension(120, 35));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 35));
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(120,35));

        buttonPanel.add(reserveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        panel.add(buttonPanel, gbc);

        add(panel);

        // ===========================
        // Reserve Button Action
        // ===========================
        reserveButton.addActionListener(e -> {

            String passengerName = passengerField.getText().trim();
            String trainNumber = trainNumberField.getText().trim();
            String trainName = trainNameField.getText().trim();
            String classType = classField.getText().trim();
            String journeyDate = dateField.getText().trim();
            String source = sourceField.getText().trim();
            String destination = destinationField.getText().trim();

            if (passengerName.isEmpty() ||
                trainNumber.isEmpty() ||
                trainName.isEmpty() ||
                classType.isEmpty() ||
                journeyDate.isEmpty() ||
                source.isEmpty() ||
                destination.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields!",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }
            
         // NEW VALIDATION
            if (!trainNumber.matches("\\d+")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Train Number should contain only digits.",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }
            
            if (!journeyDate.matches("\\d{2}-\\d{2}-\\d{4}")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Journey Date must be in DD-MM-YYYY format.",
                        "Invalid Date",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }
            
            
            if (source.equalsIgnoreCase(destination)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Source and Destination cannot be the same.",
                        "Invalid Route",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            String pnrNumber = ReservationService.addReservation(
                    passengerName,
                    trainNumber,
                    trainName,
                    classType,
                    journeyDate,
                    source,
                    destination);

            if (pnrNumber != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation Booked Successfully!\n\n"
                        + "Your PNR Number is:\n"
                        + pnrNumber,
                        "Booking Successful",
                        JOptionPane.INFORMATION_MESSAGE);

                passengerField.setText("");
                trainNumberField.setText("");
                trainNameField.setText("");
                classField.setText("");
                dateField.setText("");
                sourceField.setText("");
                destinationField.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to Book Reservation!",
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        });

        // ===========================
        // Back Button Action
        // ===========================
        backButton.addActionListener(e -> {

            new DashboardFrame();

            dispose();

        });
        
        // clear button
        clearButton.addActionListener(e -> {

            passengerField.setText("");
            trainNumberField.setText("");
            trainNameField.setText("");
            classField.setText("");
            dateField.setText("");
            sourceField.setText("");
            destinationField.setText("");

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new ReservationFrame());

    }
}