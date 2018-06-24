package calculator;

import javax.swing.*;

/* This class will work as an application control pattern that will interact with the MVC
classes on this calculator program */
public class Calculator {

    public static void main(String[] args) {
        /*Create new model, view and controller */
        CalculatorModel model           = new CalculatorModel();
        CalculatorView view             = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        /*register controller as listener */
        view.registerListener(controller);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(400, 300);
        view.setVisible(true);
    }
}
