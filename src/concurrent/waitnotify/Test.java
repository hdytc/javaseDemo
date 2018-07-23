package concurrent.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Object lock = new Object();

        new Waiter(list,lock).start();
        new Waiter(list,lock).start();

        Thread.sleep(500);
        new Notifier(list,lock).start();
        new Notifier(list,lock).start();
    }
}
