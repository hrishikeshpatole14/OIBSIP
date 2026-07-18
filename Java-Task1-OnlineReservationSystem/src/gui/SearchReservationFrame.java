package gui;

import javax.swing.*;
import java.awt.*;

import model.Reservation;
import service.SearchReservationService;

public class SearchReservationFrame extends JFrame {

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
    JButton backButton;

    public SearchReservationFrame() {

        setTitle("Online Reservation System - Search Reservation");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("SEARCH RESERVATION", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(0, 102, 204));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        // PNR Number
        formPanel.add(new JLabel("PNR Number"));
        pnrField = new JTextField();
        formPanel.add(pnrField);

        // Passenger Name
        formPanel.add(new JLabel("Passenger Name"));
        passengerField = new JTextField();
        passengerField.setEditable(false);
        formPanel.add(passengerField);

        // Train Number
        formPanel.add(new JLabel("Train Number"));
        trainNumberField = new JTextField();
        trainNumberField.setEditable(false);
        formPanel.add(trainNumberField);

        // Train Name
        formPanel.add(new JLabel("Train Name"));
        trainNameField = new JTextField();
        trainNameField.setEditable(false);
        formPanel.add(trainNameField);

        // Class
        formPanel.add(new JLabel("Class"));
        classField = new JTextField();
        classField.setEditable(false);
        formPanel.add(classField);

        // Journey Date
        formPanel.add(new JLabel("Journey Date"));
        dateField = new JTextField();
        dateField.setEditable(false);
        formPanel.add(dateField);

        // Source
        formPanel.add(new JLabel("From Station"));
        sourceField = new JTextField();
        sourceField.setEditable(false);
        formPanel.add(sourceField);

        // Destination
        formPanel.add(new JLabel("To Station"));
        destinationField = new JTextField();
        destinationField.setEditable(false);
        formPanel.add(destinationField);

        panel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(120, 35));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 35));

        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // ================= SEARCH =================

        searchButton.addActionListener(e -> {

            String pnrNumber = pnrField.getText().trim();

            if (pnrNumber.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter PNR Number.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            Reservation reservation =
                    SearchReservationService.searchReservation(pnrNumber);

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
                        "No Reservation Found with this PNR Number.",
                        "Search Result",
                        JOptionPane.INFORMATION_MESSAGE);

                passengerField.setText("");
                trainNumberField.setText("");
                trainNameField.setText("");
                classField.setText("");
                dateField.setText("");
                sourceField.setText("");
                destinationField.setText("");

            }

        });

        // ================= BACK =================

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