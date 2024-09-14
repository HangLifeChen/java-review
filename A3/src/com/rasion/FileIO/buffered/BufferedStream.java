package com.rasion.FileIO.buffered;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) {
        copyFile("resource/hello.txt","resource/hello1.txt");
    }
    public static void copyFile(String source, String destination) {
            try(    // 创建一个文件输入流
                    InputStream is=new FileInputStream(source);
                    // 创建一个缓冲输入流，把文件输入流放到缓冲输入流中
                    InputStream bis=new BufferedInputStream(is);
                    // 创建一个文件输出流
                    OutputStream os=new FileOutputStream(destination,true);
                    // 创建一个缓冲输出流，把文件输出流放到缓冲输出流中
                    OutputStream bos=new BufferedOutputStream(os);
            ){
                byte[] bytes=new byte[1024];
                int len;
                while ((len=bis.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                }
                bos.flush();
                System.out.println("文件复制成功");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
