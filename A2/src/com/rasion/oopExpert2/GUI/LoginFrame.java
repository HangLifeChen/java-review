package com.rasion.oopExpert2.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    public LoginFrame(){
        this.setTitle("登录窗口");
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();//初始化窗口组件
    }
    private void init(){
        JButton loginButton=new JButton("登录");

        loginButton.addActionListener(this);

        JPanel panel=new JPanel();
        this.add(panel);

        panel.add(loginButton);
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        JOptionPane.showMessageDialog(this, "登录成功！");
    }
}
