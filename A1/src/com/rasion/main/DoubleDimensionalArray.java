package com.rasion.main;

public class DoubleDimensionalArray {
    public static void main(String[] args) {//（二）、二维数组
        int[][] array = createArray(3, 4);
        for (int i = 0; i < array.length; i++) {//遍历二维数组
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        //访问：数组名[行索引]  即：把二维数组的某一行存为一个一维数组
        int[] str = array[0];
        for(int i=0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
        //访问长度：数组名.length
        System.out.println(array.length);//访问有几个一维数组
        System.out.println(array[0].length);//访问第0行的长度
    }
    public static int[][] createArray(int rows, int cols) {
        int[][] array = new int[rows][cols];//动态初始化
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        return array;
    }
}
