import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockWithAlarm extends JFrame {

    private JLabel clockLabel;
    private JLabel dateLabel;
    private JTextField alarmField;
    private JButton setAlarmButton;
    private String alarmTime = "";

    public DigitalClockWithAlarm() {

        setTitle("Digital Clock with Alarm");
        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));

        JLabel title = new JLabel("DIGITAL CLOCK WITH ALARM");
        title.setBounds(110, 20, 450, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        dateLabel = new JLabel();
        dateLabel.setBounds(180, 70, 300, 30);
        dateLabel.setForeground(Color.LIGHT_GRAY);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        clockLabel = new JLabel();
        clockLabel.setBounds(80, 100, 500, 80);
        clockLabel.setForeground(new Color(0, 255, 100));
        clockLabel.setFont(new Font("Consolas", Font.BOLD, 50));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel alarmLabel = new JLabel("Set Alarm (HH:mm:ss)");
        alarmLabel.setBounds(70, 220, 180, 30);
        alarmLabel.setForeground(Color.WHITE);
        alarmLabel.setFont(new Font("Arial", Font.BOLD, 16));

        alarmField = new JTextField();
        alarmField.setBounds(260, 220, 150, 35);

        setAlarmButton = new JButton("Set Alarm");
        setAlarmButton.setBounds(430, 220, 120, 35);

        panel.add(title);
        panel.add(dateLabel);
        panel.add(clockLabel);
        panel.add(alarmLabel);
        panel.add(alarmField);
        panel.add(setAlarmButton);

        add(panel);

        setAlarmButton.addActionListener(e -> {
            alarmTime = alarmField.getText().trim();

            if (alarmTime.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter alarm time!");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Alarm set for " + alarmTime);
        });

        Timer timer = new Timer(1000, e -> {

            Date now = new Date();

            String currentTime =
                    new SimpleDateFormat("HH:mm:ss").format(now);

            String currentDate =
                    new SimpleDateFormat("dd MMM yyyy").format(now);

            clockLabel.setText(currentTime);
            dateLabel.setText(currentDate);

            if (!alarmTime.isEmpty() &&
                    currentTime.equals(alarmTime)) {

                Toolkit.getDefaultToolkit().beep();

                JOptionPane.showMessageDialog(this,
                        "⏰ Alarm Time Reached!");

                alarmTime = "";
            }
        });

        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new DigitalClockWithAlarm());
    }
}