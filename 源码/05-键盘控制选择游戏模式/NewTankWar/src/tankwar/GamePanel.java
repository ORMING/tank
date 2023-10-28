package tankwar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JFrame {

    //游戏状态 0 游戏未开始， 1 单人模式， 2 双人模式， 3 游戏暂停， 4 游戏失败， 5 游戏胜利
    public int state= 0;
    //游戏是否开始
    private boolean start = false;
    //临时变量
    private int a = 1;
    //窗口长宽
    private int width = 800;
    private int height = 610;
    //指针图片
    private Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
    //指针初始纵坐标
    private int y = 150;

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

        while (true){
            repaint();
            try {
                //线程休眠  1秒 = 1000毫秒
                Thread.sleep(25);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

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
        if(state == 0){
            //添加文字
            g.drawString("选择游戏模式",220,100);
            g.drawString("单人游戏",220,200);
            g.drawString("双人游戏",220,300);
            g.drawString("按1，2选择模式，按回车开始游戏",0,400);
            g.drawImage(select,160,y,null);
        }
        else if(state == 1||state == 2){
            //添加文字
            g.drawString("游戏开始",220,300);
            if(state == 1){
                g.drawString("单人模式",220,200);
            }
            else{
                g.drawString("双人模式",220,200);
            }
        }
    }

    private class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                    if(!start){
                        y = 150;
                        a = 1;
                    }
                    System.out.println(state);
                    break;
                case KeyEvent.VK_2:
                    if(!start){
                        y = 250;
                        a = 2;
                    }
                    System.out.println(state);
                    break;
                case KeyEvent.VK_ENTER:
                    state = a;
                    start = true;
                    System.out.println("state:"+""+state);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}