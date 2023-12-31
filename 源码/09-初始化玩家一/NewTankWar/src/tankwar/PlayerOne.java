package tankwar;

import java.awt.*;

public class PlayerOne extends Tank {

    public PlayerOne(String img, int x, int y, String upImage, String downImage, String leftImage, String rightImage, GamePanel gamePanel){
        super(img, x, y, upImage, downImage, leftImage, rightImage, gamePanel);
    }

    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
