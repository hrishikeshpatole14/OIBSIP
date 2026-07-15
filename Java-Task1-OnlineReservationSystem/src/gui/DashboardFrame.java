package gui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JButton reserveButton;
    JButton cancelButton;
    JButton viewButton;
    JButton searchButton;
    JButton updateButton;
    JButton logoutButton;

    public DashboardFrame() {

        setTitle("Online Reservation System");
        setSize(550,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header
        JLabel title = new JLabel(
                "ONLINE RESERVATION SYSTEM",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD,24));
        title.setOpaque(true);
        title.setBackground(new Color(30,144,255));
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(100,60));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel centerPanel =
                new JPanel(new GridLayout(7,1,15,15));

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,60,25,60));

        JLabel welcome =
                new JLabel("Welcome, Admin");

        welcome.setHorizontalAlignment(
                SwingConstants.CENTER);

        welcome.setFont(
                new Font("Arial",Font.BOLD,18));

        centerPanel.add(welcome);

        reserveButton=new JButton("Reserve Ticket");
        cancelButton=new JButton("Cancel Reservation");
        viewButton=new JButton("View Reservations");
        searchButton=new JButton("Search Reservation");
        updateButton=new JButton("Update Reservation");
        logoutButton=new JButton("Logout");

        JButton buttons[]={
                reserveButton,
                cancelButton,
                viewButton,
                searchButton,
                updateButton,
                logoutButton
        };

        for(JButton button:buttons){

            button.setFont(
                    new Font("Arial",
                            Font.BOLD,
                            15));

            button.setFocusPainted(false);

            centerPanel.add(button);

        }

        mainPanel.add(centerPanel,
                BorderLayout.CENTER);

        add(mainPanel);

        reserveButton.addActionListener(e->{
            new ReservationFrame();
            dispose();
        });

        cancelButton.addActionListener(e->{
            new CancellationFrame();
            dispose();
        });

        viewButton.addActionListener(e->{
            new ViewReservationFrame();
            dispose();
        });

        searchButton.addActionListener(e->{
            new SearchReservationFrame();
            dispose();
        });

        updateButton.addActionListener(e->{
            new UpdateReservationFrame();
            dispose();
        });

        logoutButton.addActionListener(e->{

            int option =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to Logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION);

            if(option==JOptionPane.YES_OPTION){

                new LoginFrame();

                dispose();

            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                DashboardFrame::new);

    }

}