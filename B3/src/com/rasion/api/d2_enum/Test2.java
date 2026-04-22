package com.rasion.api.d2_enum;
/*
    1 枚举的常见应用场景：
        用来表示一组信息，然后作为参数进行传输。
    2 选择定义一个一个的常量来表示一组信息，并作为参数传输
        参数值不受约束,也没有起到见名之意,容易搞混。
    3 选择定义枚举表示一组信息，并作为参数传输
        代码可读性好，参数值得到了约束，对使用者更友好，建议使用!

    需求 :
        定义方法接收一个数据 , 来判断是男生还是女生,并展示对应的信息

    用 int 表示性别 1 男 2 女
 */
public class Test2 {
    public static  final  int BOY=1;
    public static  final  int GIRL=2;
    public static void main(String[] args) {
//        直接传递的 int 值,给开发造成不便
        showInfo(2);
//       定义常量 记录性别对应的数据,在某种程度上解决刚才的问题
//        如果传入的是非法的int值,编译也不报错
        showInfo(Test2.BOY);
        showInfo(5);

//        showInfo2(10);
    }
//    方法: 根据性别推荐对应的内容
    public static void showInfo(int sex){
        switch (sex){
            case  1:
                System.out.println("推荐男生喜欢书籍");
                break;
            case 2:
                System.out.println("推荐女生喜欢书籍");
                break;
            default:
                System.out.println("传入的值有误");
        }
    }

    public static void showInfo2(Sex sex){
       switch (sex){
           case MAN:
               System.out.println("推荐男生喜欢书籍");
               break;
           case WOMAN:
               System.out.println("推荐女生喜欢书籍");
               break;
           default:
               System.out.println("传入的值有误");
       }
    }

}
