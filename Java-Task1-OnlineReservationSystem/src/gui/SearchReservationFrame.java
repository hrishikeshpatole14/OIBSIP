package gui;

import javax.swing.*;
import java.awt.*;

import model.Reservation;
import service.SearchReservationService;

public class SearchReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField reservationIdField;
    JTextField passengerField;
    JTextField trainNumberField;
    JTextField trainNameField;
    JTextField classField;
    JTextField dateField;
    JTextField sourceField;
    JTextField destinationField;

    JButton searchButton;
    JButton backButton;

    public SearchReservationFrame() {

        setTitle("Online Reservation System - Search Reservation");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel title = new JLabel("SEARCH RESERVATION", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        formPanel.add(new JLabel("Reservation ID"));
        reservationIdField = new JTextField();
        formPanel.add(reservationIdField);

        formPanel.add(new JLabel("Passenger Name"));
        passengerField = new JTextField();
        passengerField.setEditable(false);
        formPanel.add(passengerField);

        formPanel.add(new JLabel("Train Number"));
        trainNumberField = new JTextField();
        trainNumberField.setEditable(false);
        formPanel.add(trainNumberField);

        formPanel.add(new JLabel("Train Name"));
        trainNameField = new JTextField();
        trainNameField.setEditable(false);
        formPanel.add(trainNameField);

        formPanel.add(new JLabel("Class"));
        classField = new JTextField();
        classField.setEditable(false);
        formPanel.add(classField);

        formPanel.add(new JLabel("Journey Date"));
        dateField = new JTextField();
        dateField.setEditable(false);
        formPanel.add(dateField);

        formPanel.add(new JLabel("From Station"));
        sourceField = new JTextField();
        sourceField.setEditable(false);
        formPanel.add(sourceField);

        formPanel.add(new JLabel("To Station"));
        destinationField = new JTextField();
        destinationField.setEditable(false);
        formPanel.add(destinationField);

        panel.add(formPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        searchButton = new JButton("Search");
        backButton = new JButton("Back");

        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // Search Button
        searchButton.addActionListener(e -> {

            try {

                int reservationId =
                        Integer.parseInt(reservationIdField.getText().trim());

                Reservation reservation =
                        SearchReservationService.searchReservation(reservationId);

                if (reservation != null) {

                    passengerField.setText(reservation.getPassengerName());
                    trainNumberField.setText(reservation.getTrainNumber());
                    trainNameField.setText(reservation.getTrainName());
                    classField.setText(reservation.getClassType());
                    dateField.setText(reservation.getJourneyDate());
                    sourceField.setText(reservation.getFromStation());
                    destinationField.setText(reservation.getToStation());

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Reservation Not Found!");

                    passengerField.setText("");
                    trainNumberField.setText("");
                    trainNameField.setText("");
                    classField.setText("");
                    dateField.setText("");
                    sourceField.setText("");
                    destinationField.setText("");

                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid Reservation ID.");

            }

        });

        // Back Button
        backButton.addActionListener(e -> {

            new DashboardFrame();
            dispose();

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new SearchReservationFrame());

    }
}