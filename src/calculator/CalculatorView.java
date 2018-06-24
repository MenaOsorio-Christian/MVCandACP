package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    //Display calculator
    private JLabel display;

    //buttons of the calculator
    private JPanel buttonsPanel;

    //Calculator's menu
    private JMenu exampleMenu;

    //number of fractional digits to show or -1
    private int digits;

    //creates components and panel for JFrame
    public CalculatorView() {
        super("Simple Calculator");

        //creates menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        exampleMenu = new JMenu("Menu");
        menuBar.add(exampleMenu);

        JMenuItem twoDigitsButton = new JMenuItem("Two decimals digits");
        exampleMenu.add(twoDigitsButton);

        JMenuItem anyDigitsButton = new JMenuItem("Any decimaldigits");
        exampleMenu.add(anyDigitsButton);

        JMenuItem exitButton = new JMenuItem("Exit");
        exampleMenu.add(exitButton);

        //creates display
        JPanel displayPanel = new JPanel();
        add(displayPanel, BorderLayout.NORTH);

        display = new JLabel("0.0");
        displayPanel.add(display);
        digits = -1;

        //creates buttons
        buttonsPanel = new JPanel();
        add(buttonsPanel, BorderLayout.CENTER);
        buttonsPanel.setLayout(new GridLayout(4, 4, 0, 0));

        String[] buttonString = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", ".", "=", "/"
        };

        for (String s : buttonString) {
            buttonsPanel.add(new JButton(s));
        }

    }

    public void registerListener(CalculatorController controller) {
        Component[] components = buttonsPanel.getComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button =(AbstractButton) component;
                button.addActionListener((ActionListener) controller);
            }
        }
    }

    /**
     * Display the value in the JLabel of the calculator.
     * Round off the number of digits if needed.
     *
     * @param value the value to be displayed
     */
    public void update(String value) {
        if (digits < 0) {
            display.setText(value);
        } else {
            String format = "%." + digits + "f";
            String text = String.format(format, Double.valueOf(value));
            display.setText(text);
        }
    }

    /**
     * Set the number of fractional digits to display.
     * -1 means display them all.
     *
     * @param digits the number of fractional digits to display or -1
     */
    public void setDigits(int digits) {
        this.digits = digits;
    }
}
