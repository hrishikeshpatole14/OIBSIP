package gui;

import javax.swing.*;
import java.awt.*;

import model.Reservation;
import service.SearchReservationService;
import service.UpdateReservationService;

public class UpdateReservationFrame extends JFrame {

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
    JButton updateButton;
    JButton backButton;

    public UpdateReservationFrame() {

        setTitle("Online Reservation System - Update Reservation");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel title = new JLabel("UPDATE RESERVATION", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(8,2,10,10));

        formPanel.add(new JLabel("Reservation ID"));
        reservationIdField = new JTextField();
        formPanel.add(reservationIdField);

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
        updateButton = new JButton("Update");
        backButton = new JButton("Back");

        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // Initially disable editing
        passengerField.setEditable(false);
        trainNumberField.setEditable(false);
        trainNameField.setEditable(false);
        classField.setEditable(false);
        dateField.setEditable(false);
        sourceField.setEditable(false);
        destinationField.setEditable(false);
        updateButton.setEnabled(false);

        // Search Button
        searchButton.addActionListener(e -> {

            try {

                int reservationId =
                        Integer.parseInt(reservationIdField.getText().trim());

                Reservation reservation =
                        SearchReservationService.searchReservation(reservationId);

                if(reservation != null){

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

                }else{

                    JOptionPane.showMessageDialog(this,
                            "Reservation Not Found!");

                }

            }catch(NumberFormatException ex){

                JOptionPane.showMessageDialog(this,
                        "Please enter a valid Reservation ID.");

            }

        });

        // Update Button
        updateButton.addActionListener(e -> {

            int reservationId =
                    Integer.parseInt(reservationIdField.getText());

            boolean success =
                    UpdateReservationService.updateReservation(

                            reservationId,
                            passengerField.getText(),
                            trainNumberField.getText(),
                            trainNameField.getText(),
                            classField.getText(),
                            dateField.getText(),
                            sourceField.getText(),
                            destinationField.getText()

                    );

            if(success){

                JOptionPane.showMessageDialog(this,
                        "Reservation Updated Successfully!");

            }else{

                JOptionPane.showMessageDialog(this,
                        "Update Failed!");

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
                new UpdateReservationFrame());

    }

}