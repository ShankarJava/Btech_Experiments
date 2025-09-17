package com.app.btech.experiments.trafficsignals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redBtn, yellowBtn, greenBtn;
    private JLabel message;

    public TrafficLightSimulator() {
        // Frame setup
        setTitle("Traffic Light Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Message label (initially empty)
        message = new JLabel("", SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.BOLD, 24));
        add(message, BorderLayout.NORTH);

        // Radio buttons
        redBtn = new JRadioButton("Red");
        yellowBtn = new JRadioButton("Yellow");
        greenBtn = new JRadioButton("Green");

        // Group buttons (only one selected at a time)
        ButtonGroup group = new ButtonGroup();
        group.add(redBtn);
        group.add(yellowBtn);
        group.add(greenBtn);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(redBtn);
        panel.add(yellowBtn);
        panel.add(greenBtn);
        add(panel, BorderLayout.CENTER);

        // Add listeners
        redBtn.addActionListener(this);
        yellowBtn.addActionListener(this);
        greenBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (redBtn.isSelected()) {
            message.setText("STOP");
            message.setForeground(Color.RED);
        } else if (yellowBtn.isSelected()) {
            message.setText("READY");
            message.setForeground(Color.ORANGE);
        } else if (greenBtn.isSelected()) {
            message.setText("GO");
            message.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TrafficLightSimulator().setVisible(true);
        });
    }
}
