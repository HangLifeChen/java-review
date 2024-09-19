package com.rasion.proxy;

public class main {
    public static void main(String[] args) {
        User user = new User("rasion", "123456", "rasion@qq.com");
        //创建代理对象
        UserMapper proxy = UserProxy.getInstance(user);
        System.out.println(proxy.add(user));
        proxy.delete("rasion@qq.com");
        proxy.update(user);
    }
}
