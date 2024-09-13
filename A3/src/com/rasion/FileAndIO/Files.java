package com.rasion.FileAndIO;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Files {
    public static void main(String[] args) {
        startFile();
    }

    public static void startFile(){
        //创建File对象，获取某个文件的信息，默认在工程下找
        String path = "resource\\mapper.png";//或是String path = "resource/mapper.png";
        String path2 = "resource/exists.txt";
        java.io.File file = new java.io.File(path);
        System.out.println("文件名："+file.getName());
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件是否可读："+file.canRead());
        System.out.println("文件是否可写："+file.canWrite());
        //获取字节个数
        System.out.println("文件大小："+file.length());
        System.out.println("文件大小(KB)："+new DecimalFormat("0.00").format(file.length()/1024.0) +"KB");
        System.out.println("文件大小(MB)："+new DecimalFormat("0.00").format(file.length()/(1024.0*1024))+"KB");
        //获取文件名字
        System.out.println("文件名字："+file.getName());
        //是不是文件，或文件夹
        System.out.println("是不是文件："+file.isFile());
        System.out.println("是不是文件夹："+file.isDirectory());
        //获取绝对路径
        System.out.println("绝对路径："+file.getAbsolutePath());
        //获取使用路径
        System.out.println("使用相对路径："+file.getPath());
        //获取最后修改时间，并格式化时间
        System.out.println("最后修改时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
/*
        //创建对象代表不存在的文件路径
        java.io.File file2 = new java.io.File(path2);
        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件已存在");
        }

        //创建对象代表不存在文件夹路径
        java.io.File file3 = new java.io.File("resource/test");//只能创建一级文件夹
        if(!file3.exists()) {
            file3.mkdir();
        }else {
            System.out.println("文件夹已存在");
        }
        //创建多级文件夹
        java.io.File file4 = new java.io.File("resource/test/test2/test3");//创建多级文件夹
        if(!file4.exists()) {
            file4.mkdirs();
        }else {
            System.out.println("文件夹已存在");
        }

        //删除操作
        System.out.println("删除"+path2+"结果："+file2.delete());
        System.out.println("删除resource/test/test2/test3结果："+file4.delete());
        //只能删除空文件夹，不能删除非空文件夹,，删除后的文件不会进回收站
        //要想删除有文件的文件夹，只能用递归算法写方法删除
*/
        //获取某个文件夹下的所有一级文件名称
        java.io.File file5 = new java.io.File("resource");
        String[] fileNames = file5.list();
        System.out.println("文件夹下文件个数："+fileNames.length);
        System.out.println("文件夹下文件名称：");
        for(String name:fileNames){
            System.out.println(name);
        }
        //获取一级文件对象，还可以对文件对象进行操作
        java.io.File[] files = file5.listFiles();
        System.out.println("文件夹下文件个数："+files.length);
        System.out.println("文件夹下文件名称与路径：");
        for(java.io.File f:files){//获取绝对路径
            System.out.println(f.getName()+":"+f.getAbsolutePath());
        }
        /**
         * 对listFiles()方法注意
         * 当主调是文件，或者路径不存在，返回null
         * 主调是空文件夹，返回长度为0的数组
         * 主调是一个有内容的文件夹时，将里面的所有一级文件和文件夹的路径放在File数组中返回
         * 当主调是一个文件夹，且里面有隐藏文件时，将里面的所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
         * 当主调是一个文件夹，但是没有权限访问该问价夹时，返回null。
         */
        java.io.File file6 = new java.io.File("resource/test");
        java.io.File[] files2 = file6.listFiles();
        System.out.println(Arrays.toString(files2));
    }
}
