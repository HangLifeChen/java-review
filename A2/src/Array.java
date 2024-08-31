import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
//        staticArray();//1、创建数组，静态初始化数组
//        dynamicArray();//2、创建数组，动态初始化数组
        Integer[] scores = new Integer[]{10,40,50,60,70,80,90,100,110,120};
        Integer max = Array.arrayMax(scores);//3、获取数组中的最大值
        System.out.println("最大成绩是："+max);
    }

    public static void staticArray() {//1、创建数组，静态初始化数组
        //定义一个数组，存储10个学生姓名
        String[] names = {"张三", "李四", "王五", "赵六", "田七", "孙八", "周九", "吴十", "郑十一", "王十二"};
        //随机获取一个索引
        int index = (int) (Math.random() * names.length);
        System.out.println(names[index]);
    }

    public static void dynamicArray() {//2、创建数组，动态初始化数组
        //定义一个数组，存储10个学生姓名
        Integer[] scores = new Integer[10];
        //录入10名学生成绩，存到数组中去
        for (int i = 0; i < scores.length; i++) {
//            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
//            scores[i] = new Scanner(System.in).nextInt();
            scores[i] = (int)(Math.random() * 100);
        }
        int index = (int) (Math.random() * scores.length);
        System.out.println("第"+(index+1)+"个人成绩是："+scores[index]);
    }

    public static Integer arrayMax(Integer[] sc) {//3、获取数组中的最大值
        Integer max = sc[0];
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] > max) {
                max = sc[i];
            }
        }
        return max;
    }

    public static void arraySort(Integer[] sc) {//4、对数组进行排序
        for (int i = 0; i < sc.length; i++) {
            for (int j = 0; j < sc.length - i - 1; j++) {
                if (sc[j] > sc[j + 1]) {
                    int temp = sc[j];
                    sc[j] = sc[j + 1];
                    sc[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < sc.length; i++) {
            System.out.println(sc[i]);
        }
    }
}

