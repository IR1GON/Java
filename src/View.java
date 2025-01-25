import javax.swing.*;
import java.awt.*;


class View {
    private JFrame frame;
    private JLabel label;
    private JButton button;

    public View() {
        frame = new JFrame("MVC Приклад");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        label = new JLabel("Початковий текст");
        button = new JButton("Змінити текст");

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
    }

    public JButton getButton() {
        return button;
    }

    public JLabel getLabel() {
        return label;
    }
}
