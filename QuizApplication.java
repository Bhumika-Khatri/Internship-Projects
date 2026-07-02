
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApplication extends JFrame implements ActionListener {
    String[] q = {
        "1. Capital of India?",
        "2. Java is a ...?",
        "3. 2 + 2 = ?",
        "4. HTML stands for?",
        "5. Which is not OOP?"
    };
    String[][] o = {
        {"Mumbai","Delhi","Chennai","Kolkata"},
        {"Language","OS","Browser","Database"},
        {"3","4","5","6"},
        {"Hyper Text Markup Language","High Text Machine Language","Home Tool Markup Language","None"},
        {"Encapsulation","Inheritance","Compilation","Polymorphism"}
    };
    int[] ans={1,0,1,0,2};
    ButtonGroup bg=new ButtonGroup();
    JRadioButton[] rb=new JRadioButton[4];
    JLabel ques=new JLabel();
    JLabel scoreLbl=new JLabel("Score: 0");
    JProgressBar bar=new JProgressBar(0,q.length);
    JButton next=new JButton("Next");
    int idx=0,score=0;

    QuizApplication(){
        setTitle("Quiz Application");
        setSize(650,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top=new JPanel(new BorderLayout());
        top.setBackground(new Color(37,99,235));
        JLabel title=new JLabel("Quiz Application",SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,24));
        top.add(title,BorderLayout.CENTER);
        add(top,BorderLayout.NORTH);

        JPanel center=new JPanel();
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
        ques.setFont(new Font("Arial",Font.BOLD,18));
        center.add(ques);
        for(int i=0;i<4;i++){
            rb[i]=new JRadioButton();
            bg.add(rb[i]);
            center.add(rb[i]);
        }
        add(center,BorderLayout.CENTER);

        JPanel bottom=new JPanel();
        bar.setStringPainted(true);
        bottom.add(bar);
        bottom.add(scoreLbl);
        next.addActionListener(this);
        bottom.add(next);
        add(bottom,BorderLayout.SOUTH);

        loadQuestion();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadQuestion(){
        bg.clearSelection();
        ques.setText(q[idx]);
        for(int i=0;i<4;i++) rb[i].setText(o[idx][i]);
        bar.setValue(idx+1);
        if(idx==q.length-1) next.setText("Submit");
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0;i<4;i++){
            if(rb[i].isSelected() && i==ans[idx]) score++;
        }
        scoreLbl.setText("Score: "+score);
        idx++;
        if(idx<q.length){
            loadQuestion();
        }else{
            JOptionPane.showMessageDialog(this,
                "Quiz Completed!\nScore: "+score+" / "+q.length);
            System.exit(0);
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(QuizApplication::new);
    }
}
