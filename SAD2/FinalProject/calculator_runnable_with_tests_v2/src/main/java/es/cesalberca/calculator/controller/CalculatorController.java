package es.cesalberca.calculator.controller;

import es.cesalberca.calculator.model.CalculatorModel;
import es.cesalberca.calculator.observer.Observer;
import es.cesalberca.calculator.view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorController implements Observer {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController (CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        // Attach listeners from the view to the controller's logic
        this.view.addCalculationListener(new CalculateListener());
        this.view.addOperationListener(new OperationListener());
        this.view.addClearListener(new ClearListener());
        
        // Register controller as an observer of the model
        this.model.registerObserver(this);
        
        // Initial update
        update();
    }

    private class CalculateListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            // Get the digit pressed
            String text = ((JButton)e.getSource()).getText();
            int numberUserPressed = Integer.parseInt(text);
            
            // Update the model
            model.addDigit(numberUserPressed);
        }
    }

    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operationPressed = ((JButton)e.getSource()).getText();

            if (Objects.equals(operationPressed, "=")) {
                // Execute the operation and set the result as the new number
                double result = model.makeOperation();
                model.setNumber(result);
                model.setPreviousNumber(0); // Clear previous number
                model.setCurrentTypeOfOperation(""); // Clear operation
            } else {
                // Set the operation and move the current number to previousNumber
                model.setCurrentTypeOfOperation(operationPressed);
                model.setPreviousNumber(model.getNumber());
                model.setNumber(0); // Reset current number for new input
            }
        }
    }
    
    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setNumber(0);
            model.setPreviousNumber(0);
            model.setCurrentTypeOfOperation("");
        }
    }

    @Override
    public void update() {
        // Update the view based on the model's state
        view.setNumber(model.getNumber());
        view.setPreviousNumber(model.getPreviousNumber(), model.getCurrentTypeOfOperation());
    }
}
