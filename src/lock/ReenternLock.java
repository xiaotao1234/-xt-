package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/15 10:40
 */
public class ReenternLock {
    public static void main(String[] args) {
        ReenternLock s = new ReenternLock();
        System.out.println();
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> get(lock);
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable runnable1 = () -> {
            thread.interrupt();
            lock.lock();
            pr(2);
            lock.unlock();
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();
    }

    public static void get(ReentrantLock lock) {
        try {
            lock.lockInterruptibly();
            pr(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void pr(int i) {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
