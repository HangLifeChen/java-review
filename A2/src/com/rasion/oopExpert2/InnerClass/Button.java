package com.rasion.oopExpert2.InnerClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    //匿名内部类的应用场景
    public static void main(String[] args) {
        JFrame frame=new JFrame("Login window");
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);//显示居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//界面大小

        JPanel panel=new JPanel();
        frame.add(panel);

        JButton button=new JButton("login");
        panel.add(button);

        //java给按钮绑定一个监听器事件，以便做出反应
        //开发中不是主动写匿名内部类，而是调用别人的代码时需要我们写一个匿名内部类
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("login success");
            }
        });
//        button.addActionListener(e -> System.out.println("login success"));
        frame.setVisible(true);
    }
}
