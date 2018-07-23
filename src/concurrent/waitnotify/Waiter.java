package concurrent.waitnotify;

import java.util.List;

public class Waiter extends Thread{
    private final List<String> list;
    private final Object lock;

    public Waiter(List<String> list, Object lock) {
        this.list = list;
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            try {
                //jdk api: In other words, waits should always occur in loops
                //一个现象是当代码改为notifyall时，使用if会出现问题。
                while (list.size() == 0) {
                    System.out.println("list size==0,wait");
                    lock.wait();
                }
                list.remove(0);
                System.out.println("list remove success.list size: "+list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
