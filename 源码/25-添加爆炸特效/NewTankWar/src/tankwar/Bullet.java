package tankwar;

import java.awt.*;
import java.util.List;

public class Bullet extends GameObject{
    //长宽
    private int width = 10;
    private int height = 10;
    //速度
    private int speed = 7;
    //方向
    Direction direction;
    //构造函数
    public Bullet(String img, int x, int y, Direction direction,GamePanel gamePanel) {
        super(img, x,  y, gamePanel);
        this.direction = direction;
    }

    public void go(){
        moveToBorder();
        hitBase();
        hitWall();
        switch (direction){
            case UP:
                upward();
                break;
            case LEFT:
                leftward();
                break;
            case DOWN:
                downward();
                break;
            case RIGHT:
                rightward();
                break;
        }
    }

    /**子弹与坦克碰撞检测*/
    public void hitBot(){
        Rectangle next= this.getRec();
        List<Bot> bots = this.gamePanel.botList;
        //子弹和bot
        for(Bot bot: bots){
            if(bot.getRec().intersects(next)){
                System.out.println("hit bot");
                this.gamePanel.blastList.add(new BlastObj(bot.x-34, bot.y-14));
                this.gamePanel.botList.remove(bot);
                this.gamePanel.removeList.add(this);
                break;
            }
        }
    }

    public void hitWall() {
        Rectangle next = this.getRec();
        List<Wall> walls = this.gamePanel.wallList;
        for (Wall w : walls) {
            if (w.getRec().intersects(next)) {
                this.gamePanel.wallList.remove(w);
                this.gamePanel.removeList.add(this);
                break;
            }
        }
    }

    public void moveToBorder(){
        if (x < 0||x > this.gamePanel.getWidth()) {
            this.gamePanel.removeList.add(this);
            System.out.println("bullet hit border");
        }
        if(y < 0||y > this.gamePanel.getHeight()){
            this.gamePanel.removeList.add(this);
            System.out.println("bullet hit border");
        }
    }

    public void hitBase(){
        Rectangle next = this.getRec();
        for(Base base: gamePanel.baseList) {
            if (base.getRec().intersects(next)) {
                this.gamePanel.baseList.remove(base);
                this.gamePanel.removeList.add(this);
                break;
            }
        }
    }

    public void leftward(){
        x -= speed;
    }
    public void rightward(){
        x += speed;
    }
    public void upward(){
        y -= speed;
    }
    public void downward(){
        y += speed;
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        go();
        hitBot();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
