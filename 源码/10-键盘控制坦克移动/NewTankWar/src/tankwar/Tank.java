package tankwar;

import java.awt.*;

public class Tank extends GameObject{

    private String upImage; //向上移动时的图片
    private String downImage;//向下移动时的图片
    private String rightImage;//向右移动时的图片
    private String leftImage;//向左移动时的图片
    //坦克size
    int width = 40;
    int height = 50;
    //坦克初始方向
    Direction direction = Direction.UP;
    //坦克速度
    private int speed = 3;

    //坦克坐标，方向，图片，方向，面板
    public Tank(String img, int x, int y, String upImage, String downImage, String leftImage, String rightImage, GamePanel gamePanel) {
        super(img, x, y, gamePanel);
        this.upImage = upImage;
        this.leftImage = leftImage;
        this.downImage = downImage;
        this.rightImage = rightImage;
    }

    public void leftward(){
        direction = Direction.LEFT;
        setImg(leftImage);
        this.x -= speed;

    }
    public void rightward(){
        direction = Direction.RIGHT;
        setImg(rightImage);
        this.x += speed;

    }
    public void upward(){
        direction = Direction.UP;
        setImg(upImage);
        this.y -= speed;

    }
    public void downward(){
        direction = Direction.DOWN;
        setImg(downImage);
         this.y += speed;

    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
