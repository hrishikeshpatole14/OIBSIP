package gui;

import javax.swing.*;
import java.awt.*;

import service.CancellationService;

public class CancellationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField pnrField;
    private JButton cancelButton;
    private JButton backButton;

    public CancellationFrame() {

        setTitle("Online Reservation System - Cancel Reservation");
        setSize(450, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // PNR Number
        panel.add(new JLabel("PNR Number"));
        pnrField = new JTextField();
        panel.add(pnrField);

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

            String pnrNumber = pnrField.getText().trim();

            if (pnrNumber.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter PNR Number.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to cancel this reservation?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {

                boolean success =
                        CancellationService.cancelReservation(pnrNumber);

                if (success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Reservation Cancelled Successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    pnrField.setText("");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "No Reservation Found with this PNR Number.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                }

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