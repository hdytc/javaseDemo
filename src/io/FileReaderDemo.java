package io;

import java.io.*;

public class FileReaderDemo {
    /**
     * 模拟powershell默认的重定向持续输出logging到文件的场景
     * @param args
     */
    public static void main(String[] args) {
        String filename = "d:/11.txt";
        //test1(filename);
        fix1(filename);
    }

    /**
     * 如果文件为UCS-2带bom编码，会出现2个问题：
     * 问题1：中文乱码。（filereader继承InputStreamReader但是没有实现其中的编码类型，因此不建议使用。）
     * 问题2：伴随着乱码，输出会变成2行空格。
     */
    private static void test1(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while(true) {
                String singleLine;
                while ((singleLine = bufferedReader.readLine()) != null) {
                    System.out.println(singleLine);
                }
                System.out.println("***Waiting for logging***");
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * fix1的问题：后续logging如果持续写入会造成后续字符乱码。
     * @param filename
     */
    private static void fix1(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Unicode"))) {
            while (true) {
                String singleLine;
                while ((singleLine = bufferedReader.readLine()) != null) {
                    System.out.println(singleLine);
                }
                System.out.println("***Waiting for logging***");
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
