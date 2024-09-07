package com.rasion.oopExpert2.GUI;

import javax.swing.*;
import java.awt.*;

public class Swing {
    public static void main(String[] args) {
//        createWindow();//普通的创建一个窗口
//        createWindowFlowLayout();//创建一个FlowLayout布局的窗口
//        createWindowBorderLayout();//创建一个BorderLayout布局的窗口
//        createWindowGridLayout();//创建一个GridLayout布局的窗口
        createWindowBoxLayout();
    }

    //创建一个窗口，有一个登录按钮
    public static void createWindow() {//普通的创建一个窗口
        JFrame frame = new JFrame("登录窗口");//创建窗口

        JPanel panel = new JPanel();//创建面板
        frame.add(panel);//添加面板

        frame.setSize(300, 200);//设置窗口大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口默认操作：关闭窗口，推出程序

        JButton button=new JButton("登录");//创建按钮
        button.setBounds(100,100,80,30);//设置按钮位置和宽高
        panel.add(button);//添加按钮到面板
        frame.setVisible(true);//显示窗口
    }

    private static void createWindowFlowLayout() {//创建一个FlowLayout布局的窗口
        JFrame frame = new JFrame("FlowLayout布局管理器");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());//设置窗口的布局管理器对象

        frame.add(new JButton("按钮1"));
        frame.add(new JButton("按钮2"));

        frame.setVisible(true);
    }

    private static void createWindowBorderLayout() {//创建一个BorderLayout布局的窗口
        JFrame frame = new JFrame("BorderLayout布局管理器");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());//设置窗口的布局管理器对象

        frame.add(new JButton("按钮1"), BorderLayout.NORTH);
        frame.add(new JButton("按钮2"), BorderLayout.SOUTH);
        frame.add(new JButton("按钮3"), BorderLayout.CENTER);
        frame.add(new JButton("按钮4"), BorderLayout.EAST);
        frame.add(new JButton("按钮5"), BorderLayout.WEST);

        frame.setVisible(true);
    }

    private static void createWindowGridLayout() {//创建一个GridLayout布局的窗口，可以做计算器
        JFrame frame = new JFrame("GridLayout布局管理器");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(2, 3));//设置窗口的布局管理器对象

        for (int i = 0; i < 6; i++) {
            frame.add(new JButton("按钮" + i));
        }
        frame.setVisible(true);
    }

    private static void createWindowBoxLayout() {
        JFrame frame = new JFrame("BoxLayout布局管理器");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//垂直排列

        panel.add(new JButton("按钮1"));
        panel.add(Box.createVerticalStrut(10));//垂直间距
        panel.add(new JButton("按钮2"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JButton("按钮3"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
