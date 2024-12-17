// Main.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Geometry and Animals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton calculateAreasButton = new JButton("Calculate Areas");
        calculateAreasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                Circle circle = new Circle(5);
                Rectangle rectangle = new Rectangle(4, 6);
                Triangle triangle = new Triangle(3, 7);

                textArea.append("Circle area: " + circle.calculateArea() + "\n");
                textArea.append("Rectangle area: " + rectangle.calculateArea() + "\n");
                textArea.append("Triangle area: " + triangle.calculateArea() + "\n\n");
            }
        });

        JButton displayAnimalSoundsButton = new JButton("Display Animal Sounds");
        displayAnimalSoundsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                Dog dog = new Dog();
                Cat cat = new Cat();
                Bird bird = new Bird();

                textArea.append("Dog sound: " + dog.makeSound() + ", Food: " + dog.getFoodType() + "\n");
                textArea.append("Cat sound: " + cat.makeSound() + ", Food: " + cat.getFoodType() + "\n");
                textArea.append("Bird sound: " + bird.makeSound() + ", Food: " + bird.getFoodType() + "\n");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(calculateAreasButton);
        buttonPanel.add(displayAnimalSoundsButton);

        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
