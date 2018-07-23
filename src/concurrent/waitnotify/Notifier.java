package concurrent.waitnotify;

import java.util.List;

public class Notifier extends Thread {
    private final List<String> list;
    private final Object lock;

    public Notifier(List<String> list, Object lock) {
        this.list = list;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            list.add("ffff");
            System.out.println("list add success,list size: "+list.size());
            lock.notifyAll();
        }
    }
}
