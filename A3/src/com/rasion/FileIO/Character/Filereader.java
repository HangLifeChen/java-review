package com.rasion.FileIO.Character;

import java.io.FileReader;
import java.io.Reader;

public class Filereader {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFile() throws Exception {
        //文件字符输入流读取文件中的字节数组到内存中去
        try(Reader fr = new FileReader("resource/hello.txt");){
            char[] chars = new char[3];//创建一个数组，用来存储读取的字符数组
            int len = fr.read(chars);
            while (len!=-1){
                System.out.print(new String(chars,0,len));
                len = fr.read(chars);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
