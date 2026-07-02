import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {

    private JTextField tempField;
    private JLabel resultLabel;
    private JButton cToFButton, fToCButton, clearButton;

    public TemperatureConverter() {

        setTitle("Temperature Converter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setLayout(null);

        JLabel title = new JLabel("🌡 Temperature Converter");
        title.setBounds(120, 20, 400, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(70, 90, 180, 30);
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(new Font("Arial", Font.BOLD, 18));

        tempField = new JTextField();
        tempField.setBounds(250, 90, 200, 35);
        tempField.setFont(new Font("Arial", Font.PLAIN, 18));

        cToFButton = new JButton("Celsius → Fahrenheit");
        cToFButton.setBounds(70, 160, 220, 45);
        cToFButton.setFont(new Font("Arial", Font.BOLD, 14));

        fToCButton = new JButton("Fahrenheit → Celsius");
        fToCButton.setBounds(310, 160, 220, 45);
        fToCButton.setFont(new Font("Arial", Font.BOLD, 14));

        clearButton = new JButton("Clear");
        clearButton.setBounds(220, 230, 140, 40);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(70, 300, 500, 40);
        resultLabel.setForeground(new Color(0, 255, 127));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));

        cToFButton.addActionListener(this);
        fToCButton.addActionListener(this);

        clearButton.addActionListener(e -> {
            tempField.setText("");
            resultLabel.setText("Result: ");
        });

        panel.add(title);
        panel.add(inputLabel);
        panel.add(tempField);
        panel.add(cToFButton);
        panel.add(fToCButton);
        panel.add(clearButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            double temp = Double.parseDouble(tempField.getText());

            if (e.getSource() == cToFButton) {
                double fahrenheit = (temp * 9 / 5) + 32;
                resultLabel.setText(
                        String.format("Result: %.2f °F", fahrenheit));
            }

            if (e.getSource() == fToCButton) {
                double celsius = (temp - 32) * 5 / 9;
                resultLabel.setText(
                        String.format("Result: %.2f °C", celsius));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new TemperatureConverter());
    }
}