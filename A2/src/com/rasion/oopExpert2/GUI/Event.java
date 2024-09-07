package com.rasion.oopExpert2.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;

public class Event {
    public static void main(String[] args) {
        JFrame frame = new JFrame("登录窗口");
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button=new JButton("登录");
        button.setBounds(100,100,80,30);
        panel.add(button);
        frame.setVisible(true);

//        MyKeyListener(frame, button);//给窗口绑定按键监听器     //方法二、使用匿名内部类，代表监听器对象

        //方法一、直接提供实现类，用于创建监听器对象
        button.addActionListener(new MyActionListener(frame));
    }

    private static void MyKeyListener(JFrame frame, JButton button) {//按钮事件监听

        //方法二、使用匿名内部类，代表监听器对象
        //给按钮绑定一个事件监听器
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "登录成功！"));//弹出对话框

        //按键事件监听
        //给窗口绑定一个监听器
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("用户点击了Enter！");
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("用户点击了Space！");
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.out.println("用户点击了Esc！");
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("用户点击了up！");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("用户点击了down！");
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("用户点击了left！");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("用户点击了right！");
                }
            }
        });
        //让窗口获取焦点，即让窗口可以响应键盘事件
        frame.requestFocus();
        //但是点击完登陆后，焦点会变成登录按钮，此时无法响应键盘事件

    }
}

//接提供实现类，用于创建监听器对象
class MyActionListener implements ActionListener {
    private JFrame frame;
    public MyActionListener(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "ButtonAction登录成功！");
    }
}
