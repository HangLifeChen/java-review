package com.rasion.FileIO.Byte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInput {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFile() throws Exception {
        //文件字节输入流读取文件中的字节数组到内存中去
        //1、创建文件字节输入流对象
        FileInputStream fis = new FileInputStream("resource/mapper.png");
       //读取文件中字节并输出
        int a;
        while ((a = fis.read()) != -1) {//每次读取一次字节，读取汉字一定会乱码
            System.out.print(a);
        }//输出：HelloWorld!ä½ å¥½
  /*
        //每次读多个字节
        byte[] b = new byte[7];
        //定义一个变量存储每次读取的字节个数
        int len;
        while ((len = fis.read(b)) != -1) {//每次读取多个字节，与文件交互少，单读汉字有可能被截断
            System.out.print(new String(b, 0, len));//读取多少倒多少出来
        }
*/
        //定义一个与文件一样大的字节数组，这样用字节读取汉字就不会乱码，只适合读小文件
//        System.out.println(new String(fis.readAllBytes()));//用readAllBytes()方法一次性读取全部字节，避免乱码

        fis.close();
    }
}
