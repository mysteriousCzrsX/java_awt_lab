import java.awt.*;
import javax.swing.*;

public class TestFrame extends JFrame{
    public JCheckBox black = new JCheckBox("czarny");
    public JCheckBox red = new JCheckBox("czerwony");
    public LineCanvas drawPlane = new LineCanvas();

    public void init(){
        setLayout(new GridLayout());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(black);
        add(red);
        drawPlane.init();
        add(drawPlane);
        setFocusable(true);
        setVisible(true);
    }
}
