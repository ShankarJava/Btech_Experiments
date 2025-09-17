package com.app.btech.experiments.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
	private JTextField display;
	private String operator = "";
	private double num1 = 0, num2 = 0;

	public SimpleCalculator() {
		// Frame setup
		setTitle("Simple Calculator");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Display field
		display = new JTextField();
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 24));
		add(display, BorderLayout.NORTH);

		// Panel for buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 5, 5));

		// Buttons
        String[] buttons = { 
            "1", "2", "3", "+", 
            "4", "5", "6", "-", 
            "7", "8", "9", "*", 
            "0", "C", "=", "/" 
        };
		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.BOLD, 20));
			button.addActionListener(this);
			panel.add(button);
		}

		add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.matches("\\d")) { // If digit
			display.setText(display.getText() + cmd);
		} else if (cmd.equals("C")) { // Clear
			display.setText("");
			operator = "";
			num1 = num2 = 0;
		} else if (cmd.equals("=")) {
			try {
				num2 = Double.parseDouble(display.getText());
				double result = 0;

				switch (operator) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					if (num2 == 0) {
						display.setText("Error: Divide by 0");
						return;
					}
					result = num1 / num2;
					break;
				}
				display.setText(String.valueOf(result));
				operator = "";
				num1 = result;
			} catch (NumberFormatException ex) {
				display.setText("Invalid Input");
			}
		} else { // Operator
			try {
				num1 = Double.parseDouble(display.getText());
				operator = cmd;
				display.setText("");
			} catch (NumberFormatException ex) {
				display.setText("Invalid Input");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SimpleCalculator().setVisible(true);
		});
	}
}
