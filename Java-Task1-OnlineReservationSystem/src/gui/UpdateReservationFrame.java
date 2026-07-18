package gui;

import javax.swing.*;
import java.awt.*;

import model.Reservation;
import service.SearchReservationService;
import service.UpdateReservationService;

public class UpdateReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField pnrField;
    JTextField passengerField;
    JTextField trainNumberField;
    JTextField trainNameField;
    JTextField classField;
    JTextField dateField;
    JTextField sourceField;
    JTextField destinationField;

    JButton searchButton;
    JButton updateButton;
    JButton backButton;

    public UpdateReservationFrame() {

        setTitle("Online Reservation System - Update Reservation");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("UPDATE RESERVATION", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 102, 204));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        formPanel.add(new JLabel("PNR Number"));
        pnrField = new JTextField();
        formPanel.add(pnrField);

        formPanel.add(new JLabel("Passenger Name"));
        passengerField = new JTextField();
        formPanel.add(passengerField);

        formPanel.add(new JLabel("Train Number"));
        trainNumberField = new JTextField();
        formPanel.add(trainNumberField);

        formPanel.add(new JLabel("Train Name"));
        trainNameField = new JTextField();
        formPanel.add(trainNameField);

        formPanel.add(new JLabel("Class"));
        classField = new JTextField();
        formPanel.add(classField);

        formPanel.add(new JLabel("Journey Date"));
        dateField = new JTextField();
        formPanel.add(dateField);

        formPanel.add(new JLabel("From Station"));
        sourceField = new JTextField();
        formPanel.add(sourceField);

        formPanel.add(new JLabel("To Station"));
        destinationField = new JTextField();
        formPanel.add(destinationField);

        panel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(120, 35));

        updateButton = new JButton("Update");
        updateButton.setPreferredSize(new Dimension(120, 35));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 35));

        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        passengerField.setEditable(false);
        trainNumberField.setEditable(false);
        trainNameField.setEditable(false);
        classField.setEditable(false);
        dateField.setEditable(false);
        sourceField.setEditable(false);
        destinationField.setEditable(false);
        updateButton.setEnabled(false);

        // SEARCH
        searchButton.addActionListener(e -> {

            if (pnrField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter PNR Number.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            Reservation reservation =
                    SearchReservationService.searchReservation(
                            pnrField.getText().trim());

            if (reservation != null) {

                passengerField.setText(reservation.getPassengerName());
                trainNumberField.setText(reservation.getTrainNumber());
                trainNameField.setText(reservation.getTrainName());
                classField.setText(reservation.getClassType());
                dateField.setText(reservation.getJourneyDate());
                sourceField.setText(reservation.getFromStation());
                destinationField.setText(reservation.getToStation());

                passengerField.setEditable(true);
                trainNumberField.setEditable(true);
                trainNameField.setEditable(true);
                classField.setEditable(true);
                dateField.setEditable(true);
                sourceField.setEditable(true);
                destinationField.setEditable(true);

                updateButton.setEnabled(true);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No Reservation Found with this PNR.",
                        "Search Result",
                        JOptionPane.INFORMATION_MESSAGE);

            }

        });

        // UPDATE
        updateButton.addActionListener(e -> {

            if (passengerField.getText().trim().isEmpty() ||
                    trainNumberField.getText().trim().isEmpty() ||
                    trainNameField.getText().trim().isEmpty() ||
                    classField.getText().trim().isEmpty() ||
                    dateField.getText().trim().isEmpty() ||
                    sourceField.getText().trim().isEmpty() ||
                    destinationField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            boolean success =
                    UpdateReservationService.updateReservation(

                            pnrField.getText().trim(),
                            passengerField.getText().trim(),
                            trainNumberField.getText().trim(),
                            trainNameField.getText().trim(),
                            classField.getText().trim(),
                            dateField.getText().trim(),
                            sourceField.getText().trim(),
                            destinationField.getText().trim()

                    );

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Reservation Updated Successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to Update Reservation!",
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);

            }

        });

        // BACK
        backButton.addActionListener(e -> {

            new DashboardFrame();
            dispose();

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new UpdateReservationFrame());

    }
}