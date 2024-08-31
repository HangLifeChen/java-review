# JavaLearnA1

### 一、介绍

A2简介：关于java特有的基本语法学习，加上一个综合实践

### 二、基本语法

#### （一）、数组

1. 创建数组：类型[] 数组名 = new 类型[数组长度];
   

**静态初始化数组：类型[ ] 数组名 = {数组元素1,数组元素2...};**

    数组是一个容器，可以存储多个相同类型的数据。
    数组的访问：数组名[索引]。
    数组的长度：数组名.length。

```java
//以下三种方法都是可行的，都是静态初始化数组
    String[] names = {"吴十", "郑十一", "王十二"};
    String[] names = new String[]{"吴十","郑十一","王十二"};
    String names[] = new String[]{"吴十", "郑十一", "王十二"};
```
**2、动态初始化数组：类型[ ] 数组名 = new 类型[长度];**//只确定数组类型与长度，其中内容都是默认值

| 数据类型                     | 动态初始化数组元素默认值 |
| ---------------------------- | ------------------------ |
| byte、short、int、long、char | 0                        |
| float、double                | 0.0                      |
| boolean                      | false                    |
| 类、接口、数组、String       | null                     |

```java
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
```
3、求数组中的最大值
```java
    public static Integer arrayMax(Integer[] sc) {//3、获取数组中的最大值
        Integer max = sc[0];
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] > max) {
                max = sc[i];}
        }
        return max;
    }
```

4、对数组进行排序
```java
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
```

5、数组实践：扑克牌乱序发放（见Poker.java）

#### （二）、二维数组

1、静态初始化二维数组：**类型[][] 数组名 = { {元素1,元素2...}, {元素1,元素2...}...};**

2、动态初始化二维数组：**类型[][] 数组名 = new 类型[行数][列数];**

3、把二维数组的某一行存为一个一维数组：**类型[ ] 一维数组名 = 二维数组名[第n行];**

4、 访问长度：数组名.length
```java
System.out.println(二维数组名.length);//访问有几个一维数组
System.out.println(二维数组名[0].length);//访问第0行的长度
```

5、二维数组的实践：打乱二维数字（见NumberPuzzle.java）

### 三、参考

1. 学习主要链接来源于[[黑马程序员](https://www.bilibili.com/video/BV1gb42177hm?p=1&amp;vd_source=2140b8696bb75ad7bd33e1195bf24372)]
2.  其他可能用得上的链接
