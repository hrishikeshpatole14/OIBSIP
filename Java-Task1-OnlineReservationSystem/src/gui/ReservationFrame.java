package gui;

import javax.swing.*;
import java.awt.*;
import service.ReservationService;
import javax.swing.JOptionPane;

public class ReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField passengerField;
    JTextField trainNumberField;
    JTextField trainNameField;
    JTextField classField;
    JTextField dateField;
    JTextField sourceField;
    JTextField destinationField;

    JButton reserveButton;

    public ReservationFrame() {

        setTitle("Online Reservation System - Reservation");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Passenger Name
        panel.add(new JLabel("Passenger Name"));
        passengerField = new JTextField();
        panel.add(passengerField);

        // Train Number
        panel.add(new JLabel("Train Number"));
        trainNumberField = new JTextField();
        panel.add(trainNumberField);

        // Train Name
        panel.add(new JLabel("Train Name"));
        trainNameField = new JTextField();
        panel.add(trainNameField);

        // Class Type
        panel.add(new JLabel("Class Type"));
        classField = new JTextField();
        panel.add(classField);

        // Journey Date
        panel.add(new JLabel("Journey Date"));
        dateField = new JTextField();
        panel.add(dateField);

        // Source Station
        panel.add(new JLabel("Source Station"));
        sourceField = new JTextField();
        panel.add(sourceField);

        // Destination Station
        panel.add(new JLabel("Destination Station"));
        destinationField = new JTextField();
        panel.add(destinationField);

        // Button
        panel.add(new JLabel(""));

        reserveButton = new JButton("Reserve");

        panel.add(reserveButton);

        add(panel);

        // Reserve Button Action
        reserveButton.addActionListener(e -> {

            String passengerName = passengerField.getText();
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String classType = classField.getText();
            String journeyDate = dateField.getText();
            String source = sourceField.getText();
            String destination = destinationField.getText();

            if (passengerName.isEmpty() ||
                trainNumber.isEmpty() ||
                trainName.isEmpty() ||
                classType.isEmpty() ||
                journeyDate.isEmpty() ||
                source.isEmpty() ||
                destination.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields!");

                return;
            }

            boolean success = ReservationService.addReservation(
                    passengerName,
                    trainNumber,
                    trainName,
                    classType,
                    journeyDate,
                    source,
                    destination);

            if (success) {

                JOptionPane.showMessageDialog(this,
                        "Reservation Added Successfully!");

                passengerField.setText("");
                trainNumberField.setText("");
                trainNameField.setText("");
                classField.setText("");
                dateField.setText("");
                sourceField.setText("");
                destinationField.setText("");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Failed to Add Reservation!");

            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new ReservationFrame());

    }

}