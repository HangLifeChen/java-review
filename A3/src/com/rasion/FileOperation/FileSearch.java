package com.rasion.FileOperation;

import java.io.File;
import java.io.IOException;

public class FileSearch {
    public static void main(String[] args) {
//        String fileName=startFileSearch();
        File dir=new File("E:/");//搜索盘符
        try {
            searchFile(dir,"mapper.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String startFileSearch(){
        System.out.println("请输入要查找的文件名：");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextLine();
    }
    public static void searchFile(File dir,String fileName) throws IOException {
        if(dir==null || !dir.exists() || !dir.isDirectory()) return;//文件不存在
        //获取目录下的所有一级文件或文件夹对象
        File[] files=dir.listFiles();
        if(files!=null && files.length>0) {//当前目录是否存在一级目录或文件
            for (File f : files) {
                if (f.isFile()) {//判断是否为文件夹
                    if (f.getName().contains(fileName)) {//模糊查询contains，精确查询equals
                        System.out.println("文件名：" + f.getName() + " 路径：" + f.getAbsolutePath());
                        Runtime.getRuntime().exec("explorer.exe "+f.getAbsolutePath());
                    }
                } else {
                searchFile(f, fileName);//递归调用
                }
            }
        }
    }
}
