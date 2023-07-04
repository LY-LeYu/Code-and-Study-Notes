package tankgame;

public class Tank {
    private int x;
    private int y;
    private int type;
    private int direct;

    private int speed;

    public Tank(int x, int y, int type, int direct,int speed) {
        setX(x);
        setY(y);
        setType(type);
        setDirect(direct);
        setSpeed(speed);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        y-= speed;
    }
    public void moveDown() {
        y+= speed;
    }
    public void moveLeft() {
        x-=speed;
    }
    public void moveRight() {
        x+=speed;
    }
}
