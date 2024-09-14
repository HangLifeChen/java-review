package com.rasion.FileIO.Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutput {
    public static void main(String[] args) {
//        try {
//            writeFile();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try {
            copyFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFile() throws Exception{
/*        //文件字节输出流将字节数组写入文件中,当文件字节输出流输出后，文件原本的内容会被覆盖
        //1、创建文件字节输出流对象，覆盖掉原文件
        FileOutputStream fos = new FileOutputStream("resource/hello.txt");
        //2、将字节数组写入文件中
        fos.write(new byte[]{'a',100,'A',54,64});
        byte[] bytes = "hello world".getBytes();
        fos.write(bytes,0,bytes.length);
        //3、关闭文件输出流对象
        fos.close();
*/
        //追加数据
        FileOutputStream fileo = new FileOutputStream("resource/hello.txt",true);
        fileo.write("hello world".getBytes());
        fileo.close();//关闭文件输出流对象管道
    }


    public static void copyFile() {//复制文件
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("resource/mapper.png");
            fos = new FileOutputStream("resource/hello.png");
            //准备一个缓冲区
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{if(fos!=null)fos.close();}//释放资源也要检测异常，更加保险
            catch (Exception e){e.printStackTrace();}
            try{if(fos!=null)fis.close();}
            catch (Exception e){e.printStackTrace();}
        }
    }
}
