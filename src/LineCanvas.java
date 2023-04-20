import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LineCanvas extends Canvas {
    public ArrayList<Integer> keyPressHistory = new ArrayList<Integer>();

    private Color drawColor = Color.BLACK;
    private int prevX = 0;
    private int prevY = 0;
    private int nextX = 0;
    private int nextY = 0;


    LineCanvas(){
        setBackground(Color.gray);
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                keyPressHistory.add(key);
                drawLines(key);
            }
        });
    }

    private void drawLines(int key){
        Graphics g = getGraphics();
        g.setColor(drawColor);
        switch (key) {
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
        prevX = nextX;
        prevY = nextY;
    }

    public void setDrawColor(Color c){
        drawColor = c;
    }
}
