package gui;

import javax.swing.*;
import java.awt.*;

import service.CancellationService;

public class CancellationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField reservationIdField;
    private JButton cancelButton;
    private JButton backButton;

    public CancellationFrame() {

        setTitle("Online Reservation System - Cancel Reservation");
        setSize(450, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Reservation ID
        panel.add(new JLabel("Reservation ID"));
        reservationIdField = new JTextField();
        panel.add(reservationIdField);

        // Empty Row
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        // Buttons
        cancelButton = new JButton("Cancel Reservation");
        backButton = new JButton("Back");

        panel.add(cancelButton);
        panel.add(backButton);

        add(panel);

        // Cancel Button
        cancelButton.addActionListener(e -> {

            try {

                int reservationId =
                        Integer.parseInt(reservationIdField.getText().trim());

                boolean success =
                        CancellationService.cancelReservation(reservationId);

                if (success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Reservation Cancelled Successfully!");

                    reservationIdField.setText("");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Reservation ID Not Found!");

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

        SwingUtilities.invokeLater(() -> new CancellationFrame());

    }
}