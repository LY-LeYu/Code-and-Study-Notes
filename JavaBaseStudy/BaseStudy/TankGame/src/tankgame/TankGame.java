package tankgame;

import javax.swing.*;
import java.awt.*;

public class TankGame extends JFrame {
    MyPanel mp;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame(new MyPanel());
    }

    public TankGame(MyPanel mp) throws HeadlessException {
        this.mp = mp;
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1024, 576);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }
}
