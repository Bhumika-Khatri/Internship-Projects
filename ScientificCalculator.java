
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame implements ActionListener{
    JTextField display=new JTextField();
    double num1=0; String op="";
    public ScientificCalculator(){
        setTitle("Scientific Calculator");
        setSize(420,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5,5));
        display.setFont(new Font("Arial",Font.BOLD,28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display,BorderLayout.NORTH);

        JPanel p=new JPanel(new GridLayout(6,4,5,5));
        String[] b={"7","8","9","/",
                    "4","5","6","*",
                    "1","2","3","-",
                    "0",".","=","+",
                    "sqrt","x²","1/x","C",
                    "sin","cos","tan","Exit"};
        for(String s:b){
            JButton bt=new JButton(s);
            bt.setFont(new Font("Arial",Font.BOLD,18));
            bt.addActionListener(this);
            p.add(bt);
        }
        add(p,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String c=((JButton)e.getSource()).getText();
        try{
            switch(c){
                case "C": display.setText(""); op=""; break;
                case "Exit": System.exit(0);
                case "+": case "-": case "*": case "/":
                    num1=Double.parseDouble(display.getText()); op=c; display.setText(""); break;
                case "=":
                    double num2=Double.parseDouble(display.getText()),r=0;
                    if(op.equals("+")) r=num1+num2;
                    if(op.equals("-")) r=num1-num2;
                    if(op.equals("*")) r=num1*num2;
                    if(op.equals("/")) r=num1/num2;
                    display.setText(""+r); break;
                case "sqrt":
                    display.setText(""+Math.sqrt(Double.parseDouble(display.getText()))); break;
                case "x²":
                    double x=Double.parseDouble(display.getText());
                    display.setText(""+(x*x)); break;
                case "1/x":
                    display.setText(""+(1/Double.parseDouble(display.getText()))); break;
                case "sin":
                    display.setText(""+Math.sin(Math.toRadians(Double.parseDouble(display.getText())))); break;
                case "cos":
                    display.setText(""+Math.cos(Math.toRadians(Double.parseDouble(display.getText())))); break;
                case "tan":
                    display.setText(""+Math.tan(Math.toRadians(Double.parseDouble(display.getText())))); break;
                default: display.setText(display.getText()+c);
            }
        }catch(Exception ex){display.setText("Error");}
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(ScientificCalculator::new);
    }
}
