public class Poker {
    public static void main(String[] args) {
        pokerStart();
    }
    public static void pokerStart(){//发牌
        String[] poker = new String[54];
        String [] colors = {"黑桃","红桃","梅花","方快"};
        String [] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int index=0;//记录存储位置索引
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                poker[index++] = colors[i]+numbers[j];
            }
        }
        poker[index++] = "小王";
        poker[index] = "大王";
        pokerShuffle(poker);
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i]+" ");
            if((i+1)%13==0) System.out.println();
        }
    }
    public static void pokerShuffle(String[] poker){//洗牌 随机打乱
        for (int i = 0; i < poker.length; i++) {
            int index = (int)(Math.random()*poker.length);
            String temp = poker[i];
            poker[i] = poker[index];
            poker[index] = temp;
        }
    }
}
