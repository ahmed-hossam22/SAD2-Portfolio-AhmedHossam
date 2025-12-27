package es.cesalberca.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private final JTextField displayField = new JTextField("0", 20);
    private final JLabel previousOperationLabel = new JLabel(" ");
    private final JButton[] numberButtons = new JButton[10];
    private final JButton addButton = new JButton("+");
    private final JButton subtractButton = new JButton("-");
    private final JButton multiplyButton = new JButton("x");
    private final JButton divideButton = new JButton("/");
    private final JButton equalsButton = new JButton("=");
    private final JButton clearButton = new JButton("C");

    public CalculatorView() {
        // Frame setup
        this.setTitle("MVC Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());

        // Display Panel
        JPanel displayPanel = new JPanel(new BorderLayout());
        previousOperationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayPanel.add(previousOperationLabel, BorderLayout.NORTH);
        displayPanel.add(displayField, BorderLayout.CENTER);
        this.add(displayPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        
        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        // Add buttons to panel
        buttonPanel.add(clearButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(subtractButton);
        
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(addButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(equalsButton); // Will be replaced by a better layout

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(new JLabel("")); // Placeholder

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(new JLabel("")); // Placeholder
        buttonPanel.add(new JLabel("")); // Placeholder
        buttonPanel.add(equalsButton);

        this.add(buttonPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setNumber(double number) {
        if (Double.isNaN(number)) {
            displayField.setText("Error");
        } else {
            // Format to remove .0 if it's an integer
            if (number == (long) number) {
                displayField.setText(String.format("%d", (long) number));
            } else {
                displayField.setText(String.valueOf(number));
            }
        }
    }

    public void setPreviousNumber(double previousNumber, String operation) {
        if (previousNumber != 0 || !operation.isEmpty()) {
            previousOperationLabel.setText(String.format("%s %s", 
                (previousNumber == (long) previousNumber ? String.format("%d", (long) previousNumber) : String.valueOf(previousNumber)), 
                operation));
        } else {
            previousOperationLabel.setText(" ");
        }
    }

    // Listener for number buttons (0-9)
    public void addCalculationListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }

    // Listener for operation buttons (+, -, x, /, =)
    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        equalsButton.addActionListener(listener);
    }
    
    // Listener for clear button
    public void addClearListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
}
