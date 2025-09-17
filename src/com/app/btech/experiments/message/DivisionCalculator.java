package com.app.btech.experiments.message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisionCalculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton divideButton;

    public DivisionCalculator() {
        setTitle("Integer Division Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Add padding around the content
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Labels + fields
        add(new JLabel("Number 1:"));
        num1Field = new JTextField(10);  // set preferred column width
        add(num1Field);

        add(new JLabel("Number 2:"));
        num2Field = new JTextField(10);
        add(num2Field);

        add(new JLabel("Result:"));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);

        divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        add(divideButton);

        // filler
        add(new JLabel(""));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(num1Field.getText().trim());
            int num2 = Integer.parseInt(num2Field.getText().trim());

            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }

            int result = num1 / num2;
            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Invalid input: Please enter integers only",
                "NumberFormatException", JOptionPane.ERROR_MESSAGE);

        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(),
                "ArithmeticException", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DivisionCalculator());
    }
}
