package com.rasion.FileIO;

import java.io.*;

public class OtherStream {
    public static void main(String[] args) {
//        printstream();
        dataStream();
    }

    public static void printstream(){
        try(
                PrintStream ps = new PrintStream(new FileOutputStream("resource/hello.txt",true));//不能在高级管道追加，只能在低级管道追加
                PrintWriter pw = new PrintWriter(new FileOutputStream("resource/hello.txt",true));
                ){
            ps.println("hello world");
            ps.println(99);
            ps.println("你好");
            //和FileOutputStream一样，只不过PrintStream为高级管道
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void dataStream(){
        try(
//                DataOutputStream dos = new DataOutputStream(new FileOutputStream("resource/hello.txt",true));
                DataInputStream dis = new DataInputStream(new FileInputStream("resource/hello.txt"));
        ){
//            dos.writeInt(100);
//            dos.writeBoolean(true);
//            dos.writeChar('a');
//            dos.writeDouble(3.14);
//            dos.writeUTF("你好");
//            dos.flush();
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
