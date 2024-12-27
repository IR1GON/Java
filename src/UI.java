import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class UI extends JFrame implements MouseMotionListener {

    private Label label = new Label();
    private Color color = Color.black;
    private int x = 0;
    private int y = 0;
    private int brushSize = 10;
    private BufferedImage canvas;
    private JPanel drawPanel;

    UI() {
        setSize(500, 700);
        setTitle("Paint Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 500, 500);

        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvas, 0, 0, null);
            }
        };
        drawPanel.setBounds(0, 0, 500, 500);
        drawPanel.addMouseMotionListener(this);
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel);

        label.setBounds(20, 510, 200, 30);
        add(label);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(20, 550, 100, 30);
        clearButton.addActionListener(e -> {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            drawPanel.repaint();
        });
        add(clearButton);


        JButton redButton = new JButton("RED");
        redButton.setBounds(140, 550, 100, 30);
        redButton.addActionListener(e -> color = Color.red);
        add(redButton);


        JButton increaseBrushButton = new JButton("Brush +");
        increaseBrushButton.setBounds(260, 550, 100, 30);
        increaseBrushButton.addActionListener(e -> {
            if (brushSize < 50) brushSize += 5; // Максимальний розмір 50
        });
        add(increaseBrushButton);


        JButton decreaseBrushButton = new JButton("Brush -");
        decreaseBrushButton.setBounds(380, 550, 100, 30);
        decreaseBrushButton.addActionListener(e -> {
            if (brushSize > 5) brushSize -= 5; // Мінімальний розмір 5
        });
        add(decreaseBrushButton);

        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("X: " + e.getX() + " Y: " + e.getY());
        Graphics2D g = canvas.createGraphics();
        g.setColor(color);

        if (x == 0 && y == 0) {
            x = e.getX();
            y = e.getY();
            return;
        }


        g.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);

        x = e.getX();
        y = e.getY();
        drawPanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = 0;
        y = 0;
    }

    public static void main(String[] args) {
        new UI();
    }
}
