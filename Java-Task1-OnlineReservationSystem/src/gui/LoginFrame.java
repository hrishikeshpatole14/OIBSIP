package gui;

import javax.swing.*;
import java.awt.*;

import service.LoginService;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {

        setTitle("Online Reservation System - Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Username
        panel.add(new JLabel("Username"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Login Button
        panel.add(new JLabel(""));
        loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        // Login Action
        loginButton.addActionListener(e -> {

            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            // Validation
            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Username and Password.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            if (LoginService.validateLogin(username, password)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                new DashboardFrame();
                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);

                passwordField.setText("");
                passwordField.requestFocus();

            }

        });

        // Press Enter to Login
        getRootPane().setDefaultButton(loginButton);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(LoginFrame::new);

    }
}