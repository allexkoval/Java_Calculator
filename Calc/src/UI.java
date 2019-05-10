import javax.swing.*;
import java.awt.*;

public class UI{
    private double result = 0;
    private String res = "0";
    private String lastCommand = "=";
    private Font txt = new Font("SansSerif", Font.BOLD, 40);
    private Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
    private JFrame frame = new JFrame("Calculator");
    private JPanel panel = new JPanel();
    private JPanel show = new JPanel();
    private JTextField screen = new JTextField();
    private Actions act = new Actions(result, res, lastCommand, screen);
    private GridBagLayout gridbag = new GridBagLayout();
    private GridBagConstraints con = new GridBagConstraints();


    private void addButton(String name, float i, int j) {
        JButton button = new JButton(name);
        button.setFont(buttonFont);
        con.weightx = i;
        con.gridwidth = j;
        gridbag.setConstraints(button, con);
        panel.add(button);
        button.addActionListener(act);
        button.setPreferredSize(new Dimension(100, 50));
    }

    protected void buildScene() {

        show.setLayout(new BorderLayout());
        screen.setFont(txt);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setText(res);
        screen.setEnabled(false);
        show.add(screen);
        panel.setLayout(gridbag);

        con.fill = GridBagConstraints.BOTH;
        addButton("C", 1, 2);
        addButton("CE", 1, 0);
        addButton("7",1, 1);
        addButton("8", 1, 1);
        addButton("9", 1, 1);
        addButton("/", 1, 0);
        addButton("4", 0, 1);
        addButton("5", 1, 1);
        addButton("6", 1,1);
        addButton("*", 1, 0);
        addButton("1", 1, 1);
        addButton("2", 1, 1);
        addButton("3", 1, 1);
        addButton("+", 1, 0);
        addButton("0", 1, 2);
        addButton(".", 1, 1);
        addButton("-", 1, 0);
        addButton("=", 1, 0);

        frame.setLayout(new GridLayout(2, 1));
        frame.add(show);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
