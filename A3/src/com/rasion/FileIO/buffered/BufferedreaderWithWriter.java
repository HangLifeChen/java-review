package com.rasion.FileIO.buffered;

import java.io.*;

public class BufferedreaderWithWriter {
    public static void main(String[] args) {
    }
    public static void bfRW(){
        try(BufferedReader br = new BufferedReader(new FileReader("resource/hello.txt"));//创建一个文件缓冲字符输入流
            BufferedWriter bw = new BufferedWriter(new FileWriter("resource/hello2.txt"))//创建一个文件缓冲字符输出流
        ){
            String line = null;
            while ((line = br.readLine())!=null){//Buffered.readLine()读取一行为独有的换行功能，不用多态写法
                //目前读取文本最优方案
                System.out.println(line);
//                bw.write(line);//复制语句
//                bw.newLine();//换行功能
            }
        }catch (Exception e){

        }
    }
}
