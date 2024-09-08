package com.rasion.PMS.ui;

import com.rasion.PMS.bean.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RasionLoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
//定义一个静态集合存储用户信息
    private static ArrayList<User> users = new ArrayList<>();
//如果登录用集合的三个用户，获取集合的username并返回username
    public static Integer temp;
    public static String getUsername() {
        return users.get(temp).getUsername();
    }
    static {
        users.add(new User("admin", "123456", "admin"));
        users.add(new User("rasion", "123456", "rasion"));
        users.add(new User("jp", "rasion", "jp"));
    }

    public RasionLoginFrame(){
        setTitle("Rasion 人事管理系统");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createANDshow();
    }
    public void createANDshow() {
        // 创建一个面板并设置背景色
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#f0f0f0"));
        panel.setLayout(new BorderLayout());

        // 添加标题和Logo
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.decode("#f0f0f0"));

        JLabel titleLabel = new JLabel("Rasion 人事管理系统");
        titleLabel.setFont(new Font("楷体", Font.BOLD, 18));
        titleLabel.setForeground(Color.decode("#333333"));

        ImageIcon logoIcon = new ImageIcon("path/to/logo.png"); // 替换为实际的Logo路径
        JLabel logoLabel = new JLabel(logoIcon);

        headerPanel.add(titleLabel);
        headerPanel.add(logoLabel);

        panel.add(headerPanel, BorderLayout.NORTH);

        // 创建中间面板用于登录表单
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 添加用户名标签和输入框
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(10, 10, 10, 10);
        formPanel.add(new JLabel("用户名:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        // 添加密码标签和输入框
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        formPanel.add(new JLabel("密码:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // 添加登录和注册按钮
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginButton = new JButton("登录");
        registerButton = new JButton("注册");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空！");
                return;
            }
            System.out.println("用户名: " + username + ", 密码: " + password);
            //遍历集合，判断用户输入的用户名和密码是否在集合内存在
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    temp = users.indexOf(user);
                    JOptionPane.showMessageDialog(this, "登录成功！");
                    // 登录成功，跳转到员工管理界面
                    new EMFrame();
                    dispose(); // 关闭当前登录窗口
                    return;
                }//如果不存在输出提示
            }
            JOptionPane.showMessageDialog(this, "用户名或密码错误！");
        });

        registerButton.addActionListener(e -> {//注册一个用户给集合
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空！");
                return;
            }
            users.add(new User(username, password, username));
            JOptionPane.showMessageDialog(this, "注册成功！");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createHorizontalStrut(10)); // 添加水平间隔
        buttonPanel.add(registerButton);

        formPanel.add(buttonPanel, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        // 添加面板到窗口
        add(panel);

        // 显示窗口
        setVisible(true);
    }
}
