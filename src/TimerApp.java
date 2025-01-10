import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private boolean running = false;
    private int seconds = 0;

    public TimerApp() {
        setTitle("Таймер");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel(formatTime(seconds));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);

        startButton = new JButton("Старт");
        stopButton = new JButton("Стоп");
        resetButton = new JButton("Скинути");

        add(startButton);
        add(stopButton);
        add(resetButton);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    String input = JOptionPane.showInputDialog(
                            TimerApp.this,
                            "Введіть кількість секунд:",
                            "Налаштування таймера",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    try {
                        seconds = Integer.parseInt(input);
                        timeLabel.setText(formatTime(seconds));
                        running = true;
                        new Thread(new TimerTask()).start();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(TimerApp.this, "Будь ласка, введіть коректне число!");
                    }
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                seconds = 0;
                timeLabel.setText(formatTime(seconds));
            }
        });

        setVisible(true);
    }

    private String formatTime(int seconds) {
        int mins = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }

    private class TimerTask implements Runnable {
        @Override
        public void run() {
            while (running && seconds > 0) {
                try {
                    Thread.sleep(1000);
                    seconds--;
                    SwingUtilities.invokeLater(() -> timeLabel.setText(formatTime(seconds)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (seconds == 0) {
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        TimerApp.this, "Час вийшов!", "Таймер", JOptionPane.INFORMATION_MESSAGE
                ));
                running = false;
            }
        }
    }
}