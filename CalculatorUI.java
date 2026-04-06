import java.awt.*;
import javax.swing.*;

//public class CalculatorUI extends JFrame implements ActionListener {

public class CalculatorUI extends JFrame{
    private final JTextField display;
    private double num1 = 0;
    private char operator;

    public CalculatorUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            //button.addActionListener(this);
            button.addActionListener(e -> handleButton(text));
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
    }

    //@Override
   // public void actionPerformed(ActionEvent e)
    private void handleButton(String command) {
        //String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
        } else if (command.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            double result = Calculator.calculate(num1, num2, operator); 
            display.setText(String.valueOf(result));
            num1 = result;
        } else { 
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
    }
}









// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;

// public class CalculatorUI extends JFrame implements ActionListener {
//     private JTextField display;
//     private double num1 = 0;
//     private char operator;

//     public CalculatorUI() {
//         setTitle("Calculator");
//         setSize(300, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         display = new JTextField();
//         display.setEditable(false);
//         display.setFont(new Font("Arial", Font.BOLD, 24));
//         add(display, BorderLayout.NORTH);

//         JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
//         String[] buttons = {
//             "7","8","9","/",
//             "4","5","6","*",
//             "1","2","3","-",
//             "0","C","=","+"
//         };

//         for (String text : buttons) {
//             JButton button = new JButton(text);
//             button.setFont(new Font("Arial", Font.BOLD, 20));
//             button.addActionListener(this);
//             panel.add(button);
//         }
//         add(panel, BorderLayout.CENTER);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         String command = e.getActionCommand();

//         if (Character.isDigit(command.charAt(0))) {
//             display.setText(display.getText() + command);
//         } else if (command.equals("C")) {
//             display.setText("");
//             num1 = 0;
//         } else if (command.equals("=")) {
//             double num2 = Double.parseDouble(display.getText());
//             double result = Calculator.calculate(num1, num2, operator); 
//             display.setText(String.valueOf(result));
//             num1 = result;
//         } else { 
//             num1 = Double.parseDouble(display.getText());
//             operator = command.charAt(0);
//             display.setText("");
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
//     }
// }

