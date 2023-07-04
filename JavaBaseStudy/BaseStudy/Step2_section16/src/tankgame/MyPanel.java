package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Tank myTank;
    Vector<Tank> botTanks = new Vector<Tank>();
    int numOfTank = 3;
    public MyPanel() {

        myTank = new Tank(200,100,1,2,5);

        for (int i = 0; i < numOfTank; i++) {
            botTanks.add(new Tank(100*(i+1),300,2,0,1));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1024, 576);

        //绘制自己的坦克
        drawTank(g, myTank.getX(), myTank.getY(), myTank.getType(), myTank.getDirect());
        //绘制Bot的坦克
        for (int i = 0; i < numOfTank; i++) {
            Tank botTank = botTanks.get(i);
            drawTank(g, botTank.getX(), botTank.getY(), botTank.getType(), botTank.getDirect());
        }
    }

    public void drawTank(Graphics g, int x, int y, int type, int direction) {
        switch (type) {
            case 0:
                g.setColor(Color.orange);
                break;
            case 1:
                g.setColor(Color.cyan);
                break;
            case 2:
                g.setColor(Color.MAGENTA);
                break;
            default:
                System.out.println("选项无预设");
        }
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 20, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x - 10, y+10, 60, 10, false);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.fill3DRect(x, y + 20, 40, 20, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 30, y + 30, x + 50, y + 30);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 40, x + 20, y+60);
                break;
            case 3:
                g.fill3DRect(x - 10, y+10, 60, 10, false);
                g.fill3DRect(x - 10, y + 40, 60, 10, false);
                g.fill3DRect(x, y + 20, 40, 20, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 10, y + 30, x-10, y + 30);
                break;
            default:
                System.out.println("选项无预设");
                break;

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            myTank.setDirect(0);
            myTank.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            myTank.setDirect(1);
            myTank.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            myTank.setDirect(2);
            myTank.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            myTank.setDirect(3);
            myTank.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
