package es.cesalberca.calculator;

import es.cesalberca.calculator.controller.CalculatorController;
import es.cesalberca.calculator.model.CalculatorModel;
import es.cesalberca.calculator.view.CalculatorView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // 1. Create the Model
            CalculatorModel model = new CalculatorModel();
            
            // 2. Create the View
            CalculatorView view = new CalculatorView();
            
            // 3. Create the Controller and link them
            new CalculatorController(view, model);
        });
    }
}
