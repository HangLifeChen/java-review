package com.rasion.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy {
    public static UserMapper getInstance(User s) {
        /**
         * 参数一、用于执行用哪个类加载器加载生成的代理类
         * 参数二、要代理的接口——>new Class[]{UserMapper.class}或者s.getClass().getInterfaces()
         * 参数三、代理类要做的事
         */
        UserMapper usm=(UserMapper) Proxy.newProxyInstance(User.class.getClassLoader(),
                s.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 参数一、proxy接收到代理对象本身
                     * 参数二、正在被调用的方法
                     * 参数三、被代理的方法参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        //声明代理要做的事情
                        if("add".equals(method.getName()))
                            System.out.println("add");
                        else if("delete".equals(method.getName()))
                            System.out.println("delete");
                        else if("update".equals(method.getName()))
                            System.out.println("update");
                        //调用被代理的方法
                        Object result=method.invoke(s,args);
                        System.out.println(method.getName()+"耗时"+(System.currentTimeMillis()-start));
                        return result;
                    }
                });
        return usm;
    }
}
