import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class LineCanvas extends Canvas {
    public ArrayList<Integer> keyPressHistory = new ArrayList<Integer>();

    private JTextArea keyDisplay;
    private Color drawColor = Color.BLACK;
    private int prevX = 0;
    private int prevY = 0;
    private int nextX = 0;
    private int nextY = 0;


    LineCanvas(JTextArea area){
        setBackground(Color.gray);
        setVisible(true);
        keyDisplay = area;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                keyPressHistory.add(key);
                drawLines(key);
                updateKeyHistory(key);
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

    private void updateKeyHistory(int key){
        switch (key) {
            case KeyEvent.VK_UP:
                keyDisplay.append("UP\n");
                break;
            case KeyEvent.VK_DOWN:
                keyDisplay.append("DOWN\n");
                break;
            case KeyEvent.VK_RIGHT:
                keyDisplay.append("RIGHT\n");
                break;
            case KeyEvent.VK_LEFT:
                keyDisplay.append("LEFT\n");
                break;       
            default:
                break;
        }
    }

    public void setDrawColor(Color c){
        drawColor = c;
    }
}
