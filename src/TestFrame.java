import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame extends JFrame{
    private JCheckBox black = new JCheckBox("czarny");
    private JCheckBox red = new JCheckBox("czerwony");
    private JTextArea keyDisplay = new JTextArea();
    private LineCanvas drawPlane = new LineCanvas(keyDisplay);
    

    TestFrame(String title){
        super(title);
        setLayout(new GridLayout(1, 2));
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(black);
        add(red);
        add(keyDisplay);
        red.addActionListener((ActionEvent e) -> {
            if (red.isSelected()) {
                drawPlane.setDrawColor(Color.red);
            }
        });

        black.addActionListener((ActionEvent e) -> {
            if (black.isSelected()) {
                drawPlane.setDrawColor(Color.black);
            }
        });

        add(drawPlane);
        setFocusable(true);
    }
}
