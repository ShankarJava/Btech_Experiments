package com.app.btech.experiments.textfile;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TableDisplay extends JFrame {
    public TableDisplay() {
        setTitle("Table Display from File");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        java.util.List<String[]> rows = new ArrayList<>();

        // Read table data from file
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\KLR\\Experiments\\src\\com\\app\\btech\\experiments\\textfile\\Table.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                rows.add(parts);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }

        if (rows.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data found in file.");
            return;
        }

        int rowsCount = rows.size();
        int colsCount = rows.get(0).length;

        // Use GridLayout for table
        setLayout(new GridLayout(rowsCount, colsCount, 5, 5));

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                JLabel label = new JLabel(rows.get(i)[j], SwingConstants.CENTER);
                label.setOpaque(true);

                // Header style
                if (i == 0) {
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setFont(new Font("Arial", Font.BOLD, 14));
                } else {
                    label.setBackground(Color.WHITE);
                }

                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(label);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableDisplay().setVisible(true);
        });
    }
}

