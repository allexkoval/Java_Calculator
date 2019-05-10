import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions implements ActionListener {
    private double result;
    private String res;
    private String lastCommand;
    private JTextField screen;

    protected Actions(double result, String res, String lastCommand, JTextField screen) {
        this.result = result;
        this.res = res;
        this.lastCommand = lastCommand;
        this.screen = screen;
    }


    private void calculate(double x) {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                result /= x;
                break;
            case "=":
                if (result == 0) {
                    result = x;
                }
                break;
        }
        screen.setText("" + result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JButton) (e.getSource())).getText().matches("\\d") || ((JButton) (e.getSource())).getText().equals(".")) {
            if (res.equals("0") && !(((JButton) (e.getSource())).getText().equals("."))) {
                res = ((JButton) (e.getSource())).getText();
            } else {
                res = res.concat(((JButton) (e.getSource())).getText());
            }
            screen.setText(res);
        } else if (((JButton) (e.getSource())).getText().matches("[+-/*=]")) {
            calculate(Double.parseDouble(res));
            lastCommand = ((JButton) (e.getSource())).getText();
            res = "0";
        } else if (((JButton) (e.getSource())).getText().matches("[C]")) {
            lastCommand = "=";
            res = "0";
            result = 0;
            screen.setText("0");
        }
    }
}