package com.rasion.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //准备数组，用于存储数字色块的行列位置
    private int[][] img = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    public MainFrame(){
        initFrame();
        //初始化背景图片
        initImage();
        //初始化系统菜单，点击弹出菜单信息：退出、重启游戏
        initMenu();
        //显示窗口
        this.setVisible(true);
    }
    private void initMenu(){
        JMenuBar jMenuBar = new JMenuBar();//创建菜单栏
        JMenu jMenu = new JMenu("游戏");
        JMenuItem exit=new JMenuItem("退出");
        jMenu.add(exit);
        exit.addActionListener(e -> dispose());
        JMenuItem restart=new JMenuItem("重新开始");
        jMenu.add(restart);
        restart.addActionListener(e -> {System.out.println("重新开始还未开发");});
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
    }
}
