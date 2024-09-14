package com.rasion.FileIO.Performance;

import java.io.*;

public class Timetest {
    private static final String FILE_PATH = "E:\\Sakura\\Java\\Test\\resource\\peipei pv [Mystic Light Quest].mp4";//文件有13351KB
    private static final String FILE_PATH2 = "E:\\Sakura\\Java\\Test\\resource\\File\\";
    public static void main(String[] args){
        //使用低级的字节流一个一个字节的形式复制代码:36.487s，能正常打开,如果桶大小为8KB，则速度为0.015s
        copyFileByte();
        //使用低级的字符流:0.337s，文件大小为24180KB为源文件大小两倍，无法正常打开
        copyFileCharacter();
        //使用高级的缓冲字节流:0.015s，能正常打开
        copyFileBufferedByte();
        //使用高级的缓冲字符流:0.3s，文件大小为24180KB为源文件大小两倍，无法正常打开
        copyFileBufferedCharacter();
        //输出：
//        Byte复制文件耗时：36.487s//此时桶大小为1B
        //若果桶大小为1KB，则Byte速度为0.015s
//        Character复制文件耗时：0.337s
//        BufferedByte复制文件耗时：0.015s//此时桶大小为1KB
        //若果桶大小为1KB，则BufferedByte速度为0.013s
//        BufferedCharacter复制文件耗时：0.3s
    }
    private static void copyFileByte(){
        //拿系统当前时间
        long start = System.currentTimeMillis();//此刻的时间，从1970年1月1日0时0分0秒开始走到现在的毫秒数
        try(    //普通的文件输入输出流
                InputStream fis = new FileInputStream(FILE_PATH);
                OutputStream fos = new FileOutputStream(FILE_PATH2+"byte.mp4");
                ){
            byte[] chars = new byte[1024*8];//桶大小为8KB
            int b;
            while((b=fis.read(chars))!=-1){
                fos.write(chars,0,b);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();//现在的时间
        System.out.println("Byte复制文件耗时："+(end-start)/1000.0+"s");
    }

    private static void copyFileCharacter(){
        long start = System.currentTimeMillis();
        try(
                InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH));
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FILE_PATH2+"character.mp4"));
        ){
            int len;
            while((len=isr.read())!=-1){
                osw.write(len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Character复制文件耗时："+(end-start)/1000.0+"s");
    }

    private static void copyFileBufferedByte(){
        long start = System.currentTimeMillis();
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(FILE_PATH));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE_PATH2+"bufferedByte.mp4"));
        ){
            byte[] bytes = new byte[1024*8];
            int len;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("BufferedByte复制文件耗时："+(end-start)/1000.0+"s");
    }

    private static void copyFileBufferedCharacter(){
        long start = System.currentTimeMillis();
        try(
                BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
                BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH2+"bufferedCharacter.mp4"));
        ){
            int len;
            while((len=br.read())!=-1){
                bw.write(len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("BufferedCharacter复制文件耗时："+(end-start)/1000.0+"s");
    }
}
