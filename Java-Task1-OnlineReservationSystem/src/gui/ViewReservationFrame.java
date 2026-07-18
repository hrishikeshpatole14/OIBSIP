package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import model.Reservation;
import service.ViewReservationService;

public class ViewReservationFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTable table;
    JButton backButton;

    public ViewReservationFrame() {

        setTitle("Online Reservation System - View Reservations");
        setSize(1100, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String columns[] = {
                "ID",
                "PNR Number",
                "Passenger",
                "Train No",
                "Train Name",
                "Class",
                "Journey Date",
                "From",
                "To"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.setRowHeight(25);

        ArrayList<Reservation> reservationList =
                ViewReservationService.getAllReservations();

        for (Reservation r : reservationList) {

            model.addRow(new Object[] {

                    r.getReservationId(),
                    r.getPnrNumber(),
                    r.getPassengerName(),
                    r.getTrainNumber(),
                    r.getTrainName(),
                    r.getClassType(),
                    r.getJourneyDate(),
                    r.getFromStation(),
                    r.getToStation()

            });

        }

        JScrollPane scrollPane = new JScrollPane(table);

        backButton = new JButton("Back");

        backButton.addActionListener(e -> {

            new DashboardFrame();
            dispose();

        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new ViewReservationFrame());

    }

}