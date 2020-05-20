package 多线程;

import 其他.八皇后;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/5 17:56
 */
public class 三个线程依次切换打印数字从1到100 {

    public static void main(String[] args) {
        三个线程依次切换打印数字从1到100 s = new 三个线程依次切换打印数字从1到100();
        s.runThread();
    }


    private volatile int i = 0;
    private Thread thread1, thread2, thread3;
    private volatile int flag = 0;

    public void runThread() {
        thread1 = new Thread(new Thread1());
        thread2 = new Thread(new Thread2());
        thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public class Thread1 implements Runnable {

        public void run() {
            while (i < 1000) {
                if (flag == 0) {
                    System.out.println("t1=" + i);
                    i++;
                    flag = 1;
                }
            }
        }

    }

    public class Thread2 implements Runnable {

        public void run() {

            while (i < 1000) {
                if (flag == 1) {
                    System.out.println("t2=" + i);
                    i++;
                    flag = 2;
                }
            }
        }

    }

    public class Thread3 implements Runnable {

        public void run() {

            while (i < 1000) {
                if (flag == 2) {
                    System.out.println("t3=" + i);
                    i++;
                    flag = 0;
                }
            }
        }

    }

}
