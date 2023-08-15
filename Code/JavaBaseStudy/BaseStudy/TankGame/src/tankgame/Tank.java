package tankgame;

public class Tank {
    private int x;
    private int y;
    private int type;
    private int direction;

    private int speed;

    private Shot shot;

    public Tank(int x, int y, int type, int direction, int speed) {
        setX(x);
        setY(y);
        setType(type);
        setDirection(direction);
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Shot getShot() {
        return shot;
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

    public void shot() {
        switch (direction) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 50, getY() + 30, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX() - 10, getY() + 30, 3);
                break;
        }

        new Thread(shot).start();
    }
}
