package tankwar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JFrame {

    /** 定义双缓存图片 */
    Image offScreenImage = null;
    //游戏状态 0未开始 1运行中 2暂停 3失败 4成功
    int state= 0;
    //临时变量
    int a = 0;
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
        //添加键盘事件
        this.addKeyListener(new GamePanel.KeyMonitor());

    }

    @Override
    public void paint(Graphics g) {
        //设置背景颜色
        g.setColor(Color.gray);
        //填充整个画布
        g.fillRect(0, 0, width, height);
        //改变画笔颜色
        g.setColor(Color.BLUE);
        //改变文字大小和样式
        g.setFont(new Font("仿宋",Font.BOLD,50));
        //添加文字
        g.drawString("选择游戏模式",220,100);
        g.drawString("单人游戏",220,200);
        g.drawString("双人游戏",220,300);
    }

    private class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            System.out.println(key);
            System.out.println(e.getKeyChar());
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}