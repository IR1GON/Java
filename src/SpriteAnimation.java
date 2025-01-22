import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpriteAnimation extends JFrame {
    private int spriteX = 300;
    private int spriteY = 200;
    private int spriteSize = 50;
    private Image spriteImage;
    private final List<Rectangle> obstacles = new ArrayList<>();
    private final AnimationPanel animationPanel;

    public SpriteAnimation() {
        setTitle("Sprite Animation with Obstacles");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        spriteImage = new ImageIcon("D:\\java\\untitled2\\src\\main_character.jpg").getImage();

        animationPanel = new AnimationPanel();
        animationPanel.setFocusable(true);
        animationPanel.requestFocusInWindow();
        animationPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int newX = spriteX;
                int newY = spriteY;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT -> newX += 10;
                    case KeyEvent.VK_LEFT -> newX -= 10;
                    case KeyEvent.VK_DOWN -> newY += 10;
                    case KeyEvent.VK_UP -> newY -= 10;
                }

                if (!isColliding(newX, newY)) {
                    spriteX = newX;
                    spriteY = newY;
                }

                spriteX = Math.max(0, Math.min(spriteX, animationPanel.getWidth() - spriteSize));
                spriteY = Math.max(0, Math.min(spriteY, animationPanel.getHeight() - spriteSize));
                animationPanel.repaint();
            }
        });

        add(animationPanel);

        obstacles.add(new Rectangle(200, 150, 100, 100));
        obstacles.add(new Rectangle(500, 300, 150, 50));
        obstacles.add(new Rectangle(350, 400, 80, 80));

        createControlWindow();
    }

    private boolean isColliding(int x, int y) {
        Rectangle spriteBounds = new Rectangle(x, y, spriteSize, spriteSize);
        for (Rectangle obstacle : obstacles) {
            if (spriteBounds.intersects(obstacle)) {
                return true;
            }
        }
        return false;
    }

    private void createControlWindow() {
        JFrame controlWindow = new JFrame("Control Panel");
        controlWindow.setSize(300, 200);
        controlWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        controlWindow.setLayout(new GridLayout(3, 1));

        JButton increaseSizeButton = new JButton("Increase Sprite Size");
        JButton decreaseSizeButton = new JButton("Decrease Sprite Size");
        JButton resetButton = new JButton("Reset Obstacles");

        increaseSizeButton.addActionListener(e -> {
            spriteSize += 10;
            animationPanel.repaint();
        });

        decreaseSizeButton.addActionListener(e -> {
            spriteSize = Math.max(10, spriteSize - 10);
            animationPanel.repaint();
        });

        resetButton.addActionListener(e -> {
            obstacles.clear();
            obstacles.add(new Rectangle(100, 100, 100, 100));
            obstacles.add(new Rectangle(400, 200, 120, 60));
            animationPanel.repaint();
        });

        controlWindow.add(increaseSizeButton);
        controlWindow.add(decreaseSizeButton);
        controlWindow.add(resetButton);

        controlWindow.setVisible(true);
    }

    private class AnimationPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.drawImage(spriteImage, spriteX, spriteY, spriteSize, spriteSize, this);

            g.setColor(Color.RED);
            for (Rectangle obstacle : obstacles) {
                g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
            }
        }
    }}