package com.rasion.Hutool;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;


public class hutoolTest {
    public static void main(String[] args){
        FileWriter writer=new FileWriter("test.properties");
        writer.write("test");
        FileReader fileReader=new FileReader("test.properties");
        String result =fileReader.readString();
        System.out.println(result);
    }
}
