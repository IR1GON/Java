import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

class CustomSlider extends JPanel {
    private JSlider slider;
    private JLabel currentValueLabel;
    private JLabel savedValueLabel;
    private JButton saveButton;
    private int savedValue;

    public CustomSlider() {
        setLayout(new BorderLayout());

        slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        currentValueLabel = new JLabel("Current Value: " + slider.getValue(), SwingConstants.CENTER);
        savedValueLabel = new JLabel("Saved Value: None", SwingConstants.CENTER);

        saveButton = new JButton("Save Value");
        saveButton.addActionListener((ActionEvent e) -> {
            savedValue = slider.getValue();
            savedValueLabel.setText("Saved Value: " + savedValue);
        });

        slider.addChangeListener((ChangeEvent e) -> {
            int value = slider.getValue();
            currentValueLabel.setText("Current Value: " + value);
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(saveButton, BorderLayout.NORTH);
        bottomPanel.add(savedValueLabel, BorderLayout.SOUTH);

        add(slider, BorderLayout.CENTER);
        add(currentValueLabel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}