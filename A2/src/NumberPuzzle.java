import java.util.Scanner;

public class NumberPuzzle {
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        int n=scan();
        int[][] array=new int[n][n];
        //遍历二维数组，给二维数组赋值
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=i*array.length+j+1;
            }
        }
        printArray(array);//遍历二维数组
        shuffle(array);//打乱数组内容
        System.out.println("打乱后的数组：");
        printArray(array);//遍历二维数组
    }
    public static int scan(){
        //输入一个数字，确定是n*n的矩阵
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字，确定是n*n的矩阵:");
        return sc.nextInt();
    }
    public static void printArray(int[][] array){//遍历二维数组
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" \t");
            }
            System.out.println();
        }
    }
    public static void shuffle(int[][] array){//打乱数组内容
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int temp=array[i][j];
                int row=(int)(Math.random()*array.length);
                int col=(int)(Math.random()*array[i].length);
                array[i][j]=array[row][col];
                array[row][col]=temp;
            }
        }
    }
}
