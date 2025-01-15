import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpriteAnimation frame = new SpriteAnimation();
            frame.setVisible(true);
        });
    }}