package com.rasion.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    //准备数组，用于存储数字色块的行列位置
    private int[][] img = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    private int[][] win = new int[][]{//获胜状态
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //定义两个整数变量的位置
    private int row;
    private int col;
    private int count=0;
    public MainFrame(){
        initFrame();
        //打乱图片顺序
        initRandom();
        //初始化背景图片
        initImage();
        //初始化系统菜单，点击弹出菜单信息：退出、重启游戏
        initMenu();

        //给当前窗口绑定上下左右按键事件
        initKeyPress();

        //显示窗口
        this.setVisible(true);
    }
    private void initKeyPress(){//给当前窗口绑定上下左右按键事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode=e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        moveSwitch(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        moveSwitch(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        moveSwitch(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveSwitch(Direction.RIGHT);
                        break;
                }
            }
        });
    }
    private void moveSwitch(Direction direction){//控制图片移动
        switch (direction){
            case UP://向上移动
//                System.out.println("向上移动");
                if(row<img.length-1){
                    int temp=img[row][col];
                    img[row][col]=img[row+1][col];
                    img[row+1][col]=temp;
                    //更新当前空白色块位置
                    row++;
                    count++;
                }
                break;
            case DOWN://向下移动
//                System.out.println("向下移动");
                if(row>0){
                    int temp=img[row][col];
                    img[row][col]=img[row-1][col];
                    img[row-1][col]=temp;
                    //更新当前空白色块位置
                    row--;
                    count++;
                }
                break;
            case LEFT://向左移动
//                System.out.println("向左移动");
                if(col<img.length-1){
                    int temp=img[row][col];
                    img[row][col]=img[row][col+1];
                    img[row][col+1]=temp;
                    //更新当前空白色块位置
                    col++;
                    count++;
                }
                break;
            case RIGHT://向右移动
//                System.out.println("向右移动");
                if(col>0){
                    int temp=img[row][col];
                    img[row][col]=img[row][col-1];
                    img[row][col-1]=temp;
                    //更新当前空白色块位置
                    col--;
                    count++;
                }
                break;
        }
        initImage();
    }
    private void initRandom(){//打乱二维数组的顺序
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[i].length;j++){
                int temp=img[i][j];
                int row=(int)(Math.random()*4);
                int col=(int)(Math.random()*4);
                img[i][j]=img[row][col];
                img[row][col]=temp;
            }
        }//简单粗暴的打乱数组
        //找到空白色块位置
        OUT:
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[i].length;j++){
                if(img[i][j]==0){
                    row=i;
                    col=j;
                    break OUT;//退出整个循环
                }
            }
        }
    }
    private void initMenu(){
        JMenuBar jMenuBar = new JMenuBar();//创建菜单栏
        JMenu jMenu = new JMenu("菜单");
        JMenuItem exit=new JMenuItem("退出");
        jMenu.add(exit);
        exit.addActionListener(e -> dispose());
        JMenuItem about=new JMenuItem("作弊获胜");
        jMenu.add(about);
        about.addActionListener(e -> {
            for(int i=0;i<img.length;i++)
                for(int j=0;j<img[i].length;j++)
                    img[i][j]=win[i][j];
            initImage();
            if(affirm()) {
                count=0;
                initRandom();
                initImage();
            }
            OUT:
            for(int i=0;i<img.length;i++){
                for(int j=0;j<img[i].length;j++){
                    if(img[i][j]==0){
                        row=i;
                        col=j;
                        break OUT;//退出整个循环
                    }
                }
            }
        });
        JMenuItem restart=new JMenuItem("重新开始");
        jMenu.add(restart);
        restart.addActionListener(e -> {
            initRandom();
            initImage();
            count=0;
        });
        jMenuBar.add(jMenu);//添加菜单条
        this.setJMenuBar(jMenuBar);//添加菜单
    }
    private void initFrame(){
        //设置窗口的背景颜色
        this.getContentPane().setBackground(Color.white);
        //自定义一个600*560的窗口界面
        this.setTitle("石头谜阵");
        this.setSize(580,650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);//设置为空布局
    }
    private void initImage(){
        //先清空窗口上的全部图层
        this.getContentPane().removeAll();

        //每次刷新时展示步数
        JLabel jbu = new JLabel("步数："+count);
        jbu.setBounds(0,0,100,30);
        //文字颜色为红色
        jbu.setForeground(Color.RED);
        jbu.setFont(new Font("楷体",Font.BOLD,20));
        this.add(jbu);

        //展示一个行列矩阵的图片色块依次铺满的窗口4*4
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[i].length;j++){
                JLabel jLabel = new JLabel();
                jLabel.setIcon(new ImageIcon("B1/src/img/"+img[i][j]+".png"));
                jLabel.setBounds(34+j*130,55+i*130,130,130);
                this.add(jLabel);
            }
        }
        //设置背景图片
        JLabel bg=new JLabel(new ImageIcon("B1/src/img/Background.jpg"));
        bg.setBounds(0,0,580,600);
        this.add(bg);

        //判断是否胜利
        isWin();

        this.repaint();//重绘窗口
    }
    private void isWin(){
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[i].length;j++){
                if(img[i][j]!=win[i][j]){
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this,"恭喜你，你赢了！");
    }
    private boolean affirm(){
        return JOptionPane.showConfirmDialog(this,"是否要重新开始？")==0;
    }
}
