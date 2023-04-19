import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
public class LineCanvas extends Canvas {
    public ArrayList<Integer> keyPressHistory = new ArrayList<Integer>();
    public int keyPress = 0;
    public Color drawColor = Color.BLACK;

    private int prevX = getWidth()/2;
    private int prevY = getHeight()/2;
    private int nextX = 0;
    private int nextY = 0;


    LineCanvas(){
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                setKeyPress(key);
                keyPressHistory.add(key);
                repaint();
            }
        });
    }
    public void init(){
        setBackground(Color.gray);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(drawColor);
        switch (keyPress) {
            case KeyEvent.VK_UP:
                nextY = prevY - 5;
                break;
            case KeyEvent.VK_DOWN:
                nextY = prevY + 5;
                break;
            case KeyEvent.VK_RIGHT:
                nextX = prevX + 5;
                break;
            case KeyEvent.VK_LEFT:
                nextX = prevX - 5;
                break;       
            default:
                break;
        }
        g.drawLine(prevX, prevY, nextX, nextY);
        g.drawLine(10, 10, 90, 90);
        prevX = nextX;
        prevY = nextY;
        keyPress = 0;
    }

    public void setKeyPress(int k){
        keyPress = k;
    }

    public void setDrawColor(Color c){
        drawColor = c;
    }
}
