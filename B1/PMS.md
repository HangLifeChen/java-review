# 人事管理系统PMS
### 一、项目开发步骤
#### 1、创建模块（基于GUI界面）：PMS

#### 2、需求：
>(1)、提供登录注册界面
> 
>(2)、提供个人人事信息管理界面：增删改查
> 
>(3)、角色：
> 
>     登录用户（登录名称、密码，角色类型）、
>     员工信息（id、姓名、性别、年龄、电话、入职事件、职位、薪水、部门信息）
>(4)、系统界面：登录注册界面、信息管理界面

#### 3、开发
### 二、正式开发
#### 1、拿到登录界面
```java
package com.rasion.PMS.ui;

import javax.swing.*;
import java.awt.*;

public class RasionLoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

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
        });

//        registerButton.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "注册功能暂未实现！");
//        });

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
```
#### 2、定义App启动类
```java
public class App {
    public static void main(String[] args) {
        new RasionLoginFrame();
    }
}
```
#### 3、拿到管理信息界面
```java
public class EMFrame extends JFrame {
private JTable employeeTable;// 员工表格
private DefaultTableModel tableModel;// 表格模型: 用于管理表格数据
private JTextField searchField;// 搜索输入框
private List<Employee> employees = new ArrayList<>();// 员工列表

    public EMFrame() {
        // 设置窗口标题
        setTitle("Rasion的员工信息管理");

        // 设置窗口大小
        setSize(800, 600);
        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口居中显示
        setLocationRelativeTo(null);

        // 初始化员工数据
        initializeEmployees();

        // 创建一个面板并设置布局
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 第一行：输入框和搜索按钮
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        searchField = new JTextField(20);
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(e -> performSearch());
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // 中间部分：表格
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        // 创建表格模型
        tableModel = new DefaultTableModel(new Object[]{"ID", "姓名","性别","年龄","电话", "职位","入职日期","薪水","部门"}, 0);
        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 添加鼠标监听器
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // 右键点击
                    int row = employeeTable.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        showMenu(e, row);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // 添加员工数据到表格
        for (Employee employee : employees) {
            tableModel.addRow(new Object[]{employee.getId(), employee.getName(),employee.getSex(),employee.getAge(),employee.getPhone(),employee.getEntryDate(), employee.getPosition(),employee.getSalary(),employee.getDepartment()});
        }

        // 添加面板到主面板
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // 添加面板到窗口
        add(mainPanel);

        // 显示窗口
        setVisible(true);
    }

    private void initializeEmployees() {
        for (int i = 1; i <= 20; i++) {
            employees.add(new Employee(i,"员工"+i,"男",i>5?i*2:i*10,"199"+i+"09876"+i,"2024-5-1",i<3?"经理":"员工",i*i>20?i*100:i*i,"i"+i));
        }
    }

    private void performSearch() {
        String searchText = searchField.getText();
        // 这里可以添加更复杂的搜索逻辑
        // 目前仅清空表格并重新加载数据
        tableModel.setRowCount(0);
        for (Employee employee : employees) {
            if (employee.getName().contains(searchText)) {
                tableModel.addRow(new Object[]{employee.getId(), employee.getName(),employee.getSex(),employee.getAge(),employee.getPhone(),employee.getEntryDate(), employee.getPosition(),employee.getSalary(),employee.getDepartment()});
            }
        }
    }

    private void showMenu(MouseEvent e, int row) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("修改");
        JMenuItem deleteItem = new JMenuItem("删除");

        editItem.addActionListener(e1 -> editEmployee(row));
        deleteItem.addActionListener(e1 -> deleteEmployee(row));

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        popupMenu.show(employeeTable, e.getX(), e.getY());
    }

    private void editEmployee(int row) {
        int id = (int) tableModel.getValueAt(row, 0);
        String name = (String) tableModel.getValueAt(row, 1);
        String position = (String) tableModel.getValueAt(row, 2);

        // 弹出对话框获取新的信息
        String newName = JOptionPane.showInputDialog(this, "请输入新姓名:", name);
        String newPosition = JOptionPane.showInputDialog(this, "请输入新职位:", position);

        if (newName != null && newPosition != null) {
            tableModel.setValueAt(newName, row, 1);
            tableModel.setValueAt(newPosition, row, 2);
        }
    }

    private void deleteEmployee(int row) {
        int option = JOptionPane.showConfirmDialog(this, "确定要删除这条记录吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            tableModel.removeRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EMFrame::new);
    }
}
```
#### 4、准备角色类(bean包)
```java
class Employee {
private int id;
private String name;
private String sex;
private int age;
private String phone;
private String entryDate;
private String position;
private double salary;
private String department;
    ...
}
```
#### 5、开发登录、注册功能
```java
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
```
#### 6、弹出添加员工信息界面
```java
addItem.addActionListener(e1 -> {
    // 弹出对话框获取新的信息
    String newName = JOptionPane.showInputDialog(this, "请输入新姓名:");
    String newSex = JOptionPane.showInputDialog(this, "请输入新性别:");
    String newPosition = JOptionPane.showInputDialog(this, "请输入新职位:");
    
    if (newName != null && newPosition != null) {
        // 添加新员工到表格
        tableModel.addRow(new Object[]{employees.size()+1, newName,newSex,null,null,null,newPosition});
    }
});
```
### 三、学习链接
【[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=100&spm_id_from=pageDriver&vd_source=2140b8696bb75ad7bd33e1195bf24372)】
