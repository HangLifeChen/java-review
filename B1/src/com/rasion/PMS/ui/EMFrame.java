package com.rasion.PMS.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EMFrame extends JFrame {
    private JTable employeeTable;// 员工表格
    private DefaultTableModel tableModel;// 表格模型: 用于管理表格数据
    private JTextField searchField;// 搜索输入框
    private List<Employee> employees = new ArrayList<>();// 员工列表

    public EMFrame() {
        // 设置窗口标题
        setTitle(RasionLoginFrame.getUsername()+"的员工信息管理");

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
        tableModel = new DefaultTableModel(new Object[]{"ID", "姓名","性别","年龄","电话","入职日期", "职位","薪水","部门"}, 0);
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
            employees.add(new Employee(i,"员工"+i,"男",i>5?i*2:i*10,"199"+i+"09876"+i,"2024-5-1",i<3?"经理":"员工",i*i>20?i*100:i*i*10000,i<9?"部门1":"部门2"));
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
        JMenuItem addItem = new JMenuItem("添加");

        editItem.addActionListener(e1 -> editEmployee(row));
        deleteItem.addActionListener(e1 -> deleteEmployee(row));
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

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        popupMenu.add(addItem);

        popupMenu.show(employeeTable, e.getX(), e.getY());
    }

    private void editEmployee(int row) {
        int id = (int) tableModel.getValueAt(row, 0);
        String name = (String) tableModel.getValueAt(row, 1);
        String sex = (String) tableModel.getValueAt(row, 2);
        String position = (String) tableModel.getValueAt(row, 8);

        // 弹出对话框获取新的信息
        String newName = JOptionPane.showInputDialog(this, "请修改姓名:", name);
        String newSex = JOptionPane.showInputDialog(this, "请修改性别:", sex);
        String newPosition = JOptionPane.showInputDialog(this, "请修改职位:", position);

        if (newName != null && newPosition != null) {
            tableModel.setValueAt(newName, row, 1);
            tableModel.setValueAt(newSex, row,2 );
            tableModel.setValueAt(newPosition, row,8 );
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(int id, String name, String sex, int age, String phone, String entryDate, String position, double salary, String department) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.entryDate = entryDate;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
