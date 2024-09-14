package com.rasion.FileIO.Character;

import java.io.FileWriter;
import java.io.Writer;

public class Filewrite {
    public static void main(String[] args) {
        try {
            writeFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFile(){
        try(Writer writer = new FileWriter("resource/hello.txt", true)){
            writer.write("\n");
            writer.write("FileWirter",1,3);//写一部分出去
        }catch (Exception e){e.printStackTrace();}
    }
}
