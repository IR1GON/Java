import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    private JTextField displayField;
    private CalculatorLogic logic;

    public void start() {
        logic = new CalculatorLogic(this);
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        frame.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 9, 9)); // Додали ще один ряд для нових кнопок

        String[] buttonNames = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "√", "^2", "M"
        };

        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void updateDisplay(String text) {
        displayField.setText(text);
    }

    public String getDisplayText() {
        return displayField.getText();
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logic.handleButtonPress(e.getActionCommand());
        }
    }

}
