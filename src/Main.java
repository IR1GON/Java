import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Slider Example with Save Feature");
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            CustomSlider customSlider = new CustomSlider();
            frame.add(customSlider, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}