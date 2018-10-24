package security;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.CRC32;

public class MessageDigestUtil {
    public static String getHash(File file,String algorithm) {
        try(BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(file))) {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = bfi.read(buffer)) != -1) {
                md.update(buffer,0,length);
            }
            return byteArrayToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHash(byte[] bytes,String algorithm) {
        try{
            MessageDigest md5 = MessageDigest.getInstance(algorithm);
            return byteArrayToHex(md5.digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteArrayToHex(byte[] byteArray){
        //首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        //new一个字符数组，1个byte2个字符
        char[] resultCharArray = new char[byteArray.length*2];
        //遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for(byte b : byteArray){
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }

        //字符数组组合成字符串返回
        return new String(resultCharArray).toUpperCase();
    }
    public static String getCrc32(File file) {
        try(BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(file))) {
            CRC32 crc32 = new CRC32();
            byte[] buffer = new byte[8192];
            int length;
            while ((length = bfi.read(buffer)) != -1) {
                crc32.update(buffer,0,length);
            }
            return String.valueOf(crc32.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getHash(new File("D:\\JetbrainsPatchKeygen-1.2.1.jar"),"MD5"));
        System.out.println(getHash(new File("D:\\JetbrainsPatchKeygen-1.2.1.jar"),"SHA1"));
        System.out.println(getHash(new File("D:\\JetbrainsPatchKeygen-1.2.1.jar"),"SHA-256"));
        System.out.println(getCrc32(new File("D:\\JetbrainsPatchKeygen-1.2.1.jar")));
        System.out.println(getHash("asdf".getBytes(Charset.forName("utf-8")),"MD5"));
    }
}
