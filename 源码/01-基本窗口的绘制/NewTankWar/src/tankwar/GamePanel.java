package tankwar;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

    //窗口长宽
    int width = 800;
    int height = 610;
    //窗口的启动方法
    public void launch(){
        //标题
        setTitle("坦克大战");
        //窗口初始大小
        setSize(width, height);
        //使屏幕居中
        setLocationRelativeTo(null);
        //添加关闭事件
        setDefaultCloseOperation(3);
        //用户不能调整大小
        setResizable(false);
        //使窗口可见
        setVisible(true);
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}