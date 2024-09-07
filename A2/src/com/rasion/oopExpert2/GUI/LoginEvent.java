package com.rasion.oopExpert2.GUI;

public class LoginEvent {
    public static void main(String[] args) {
        //方法三、自定义一个登录界面，让界面对象本身也是事件监听器对象，把每个界面做成独立的类对象
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);//显示窗口
    }
}
