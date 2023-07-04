package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveBall extends JFrame {
    Mypanel mypanel;

    public static void main(String[] args) {
        MoveBall moveBall = new MoveBall();
    }

    public MoveBall(){
        this.mypanel = new Mypanel();
        this.add(mypanel);
        this.setSize(1024,576);
        this.addKeyListener(mypanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

class Mypanel extends JPanel implements KeyListener {
    Ball ball  = new Ball(100, 100);
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1024,576);
        g.setColor(Color.GREEN);
        g.fillOval(ball.x,ball.y,50,50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ball.y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ball.y--;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ball.x--;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ball.x++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class Ball {
    int x;
    int y;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
