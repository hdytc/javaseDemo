package concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        long[] longs = LongStream.rangeClosed(1, 100_0000).toArray();
        System.out.println("同步");
        Long result = ForkJoinPool.commonPool().invoke(new ForkJoinSumCalculator(longs));
        System.out.println(result);

        ForkJoinTask<Long> task = ForkJoinPool.commonPool().submit(new ForkJoinSumCalculator(longs));
        System.out.println("异步");
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
