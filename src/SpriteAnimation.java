import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SpriteAnimation extends JFrame {
    private int spriteX = 300;
    private int spriteY = 200;
    private final int spriteSize = 50;
    private Image spriteImage;

    public SpriteAnimation() {
        setTitle("Sprite Animation with Keyboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        spriteImage = new ImageIcon("D:\\java\\untitled2\\src\\main_character.jpg").getImage();

        AnimationPanel animationPanel = new AnimationPanel();
        animationPanel.setFocusable(true);
        animationPanel.requestFocusInWindow();
        animationPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT -> spriteX += 10; // Рух вправо
                    case KeyEvent.VK_LEFT -> spriteX -= 10;  // Рух вліво
                    case KeyEvent.VK_DOWN -> spriteY += 10;  // Рух вниз
                    case KeyEvent.VK_UP -> spriteY -= 10;    // Рух вгору
                }
                spriteX = Math.max(0, Math.min(spriteX, animationPanel.getWidth() - spriteSize));
                spriteY = Math.max(0, Math.min(spriteY, animationPanel.getHeight() - spriteSize));
                animationPanel.repaint();
            }
        });

        add(animationPanel);
    }

    private class AnimationPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(spriteImage, spriteX, spriteY, spriteSize, spriteSize, this);
        }
    }}