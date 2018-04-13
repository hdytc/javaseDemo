package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) {
        test2();
    }

    /**
     * Channel和buffer的配合与io包类似
     */
    public static void test1() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("d:/11.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead;
            while ((bytesRead = inChannel.read(buf)) != -1) {
                buf.flip();  //make buffer ready for read
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get()); // read 1 byte at a time
                }
                buf.clear(); //make buffer ready for writing
            }
            aFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 详情见https://www.adamfei.com/java-nio-transferto-transferfrom-and-read-write-mode-file-transmission-comparison-test/
     * 基于设备的DMA COPY
     */
    public static void test2() {
        try (RandomAccessFile aFile = new RandomAccessFile("d:/11.txt", "rw");
             FileChannel inChannel = aFile.getChannel();
             RandomAccessFile bFile = new RandomAccessFile("d:/11copy.txt", "rw");
             FileChannel outChannel = bFile.getChannel();)
        {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
