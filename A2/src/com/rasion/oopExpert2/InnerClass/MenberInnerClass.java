package com.rasion.oopExpert2.InnerClass;

public class MenberInnerClass {
    //成员内部类:无static修饰，属于外部类的对象持有的
    public class InnerClass{//类有的属性，方法内部类都能有
        private String num="InnerThis";
        public void print(){
            System.out.println("===innerMethod===");
            outerPrint();
            String num="-innerPrint-";
            System.out.println(num);
            System.out.println(this.num);//内部类对象
            System.out.println(MenberInnerClass.this.num);//外部类对象

            MenberInnerClass oc=new MenberInnerClass();
            System.out.println(oc.num);
            run();
        }
    }

    //内部类可以访问外部类的静态成员
    public static void outerPrint(){//外部类静态方法
        System.out.println("OuterClass static print");
    }//静态内部类，属于外部类，外部类可以访问
    private String num="OuterThis";//外部类成员变量
    public void run(){}
}
