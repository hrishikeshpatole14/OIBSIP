package gui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JButton reserveButton;
    JButton cancelButton;
    JButton logoutButton;
    JButton viewButton;

    public DashboardFrame() {

        setTitle("Online Reservation System - Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        reserveButton = new JButton("Reserve Ticket");
        cancelButton = new JButton("Cancel Ticket");
        logoutButton = new JButton("Logout");
        viewButton = new JButton("View Reservations");

        panel.add(reserveButton);
        panel.add(cancelButton);
        panel.add(viewButton);
        panel.add(logoutButton);

        add(panel);

        // Open Reservation Screen
        reserveButton.addActionListener(e -> {
            new ReservationFrame();
            dispose();
        });

        // Open Cancellation Screen
        cancelButton.addActionListener(e -> {
            new CancellationFrame();
            dispose();
        });
        
        // open view reservation
        viewButton.addActionListener(e -> {

            new ViewReservationFrame();

            dispose();

        });

        // Logout
        logoutButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardFrame());
    }
}