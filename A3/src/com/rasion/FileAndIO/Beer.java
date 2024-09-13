package com.rasion.FileAndIO;

public class Beer {
    public static void main(String[] args) {
        buy(10);
        System.out.println("总酒数：" + totalNumber);
        System.out.println("剩余盖子数：" + lastCoverNumber);
        System.out.println("剩余瓶子数：" + lastBottleNumber);
    }
    public static int totalNumber; // 总酒数
    public static int lastBottleNumber; // 每次剩余的空瓶子数
    public static int lastCoverNumber; // 每次剩余的盖子数
    public static void buy(int money) {
        /**
         * 啤酒两元一瓶，四个瓶盖可以换一瓶，两个空瓶可以换一瓶
         * 请问10元可以喝多少瓶酒，剩余多少空瓶和盖子
         *
         * 答案：喝了15瓶，剩余3盖子，1个空瓶
         *
         * 分析：
         * 1、买5瓶啤酒，喝完剩余：5个盖子，5瓶空瓶
         * 2、第一次兑换，用4个盖子和4瓶空瓶可以兑换出3瓶啤酒，
         *    多出：1个盖子，1瓶空瓶，喝完剩余：4个盖子，4瓶空瓶
         * 3、第二次兑换：用4个盖子和4瓶空瓶可以兑换出3瓶啤酒，
         *    没有多出，喝完剩余：3个盖子，3瓶空瓶
         * 4、第三次兑换：用2瓶空瓶兑换1瓶啤酒
         *    多出：3个盖子，1瓶空瓶，喝完剩余：4个盖子，2瓶空瓶
         * 5、第四次兑换：用4个盖子和2瓶空瓶兑换2瓶啤酒
         *    没有多出，喝完剩余：2个盖子，2瓶空瓶
         * 6、第五次兑换：用2瓶空瓶兑换1瓶啤酒
         *    多出2个盖子，喝完剩余：3个盖子，1瓶空瓶
         * 7、总结：总共喝了：5+3+3+1+2+1 = 15
         */
        // 1.买啤酒
        int buyNumber = money / 2;
        totalNumber += buyNumber;
        // 2.把盖子和瓶子换算成钱继续买
        // 计算本轮总的盖子数和瓶子数
        int allBottleNumber = buyNumber + lastBottleNumber;
        int allCoverNumber = buyNumber + lastCoverNumber;
        int allMoney = 0;

        if (allBottleNumber >= 2){
            allMoney += (allBottleNumber / 2) * 2;
        }
        lastBottleNumber = allBottleNumber % 2;

        if (allCoverNumber >= 4){
            allMoney += (allCoverNumber / 4) * 2;
        }
        lastCoverNumber = allCoverNumber % 4;
        if (allMoney >= 2){
            buy(allMoney);
        }
    }
}
