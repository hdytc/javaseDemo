package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class RandomAccessFileDemo {
    /**
     * 默认方法能写中文不能读中文。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        //System.setProperty("file.encoding", "Latin-1");
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        String filename ="d:/11.txt";
        writeFile(filename);
        readFileFix(filename);
    }
    public static void writeFile(String filename) {
        try (RandomAccessFile raf = new RandomAccessFile(filename,"rw")){
            raf.write("李四".getBytes());
            raf.write(97); // 'a'
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 问题：基于StringBuffer，直接传给string了原始数组，导致中文乱码。
     * 因为String会把原始数组当做latin1（又称ISO-8859-1）编码，所以要转换
     */
    public static void readFile(String filename) {
        try (RandomAccessFile raf = new RandomAccessFile(filename,"r")){
            System.out.println(raf.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileFix(String filename) {
        try (RandomAccessFile raf = new RandomAccessFile(filename,"r")){
            System.out.println(new String(raf.readLine().getBytes("ISO-8859-1"),"utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
