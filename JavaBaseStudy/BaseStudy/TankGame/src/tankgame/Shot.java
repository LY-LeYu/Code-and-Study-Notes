package tankgame;

public class Shot implements Runnable {
    int x;
    int y;
    int direction;
    int speed = 3;
    boolean alive = true;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction) {
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }

            System.out.println("横坐标："+ x +"纵坐标"+y);

            if (x <= 0 || x >= 1024 || y <= 0 || y >= 576) {
                alive = false;
                break;
            }


        }
    }


}
