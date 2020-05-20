package ThreadLocalAbout;

import 周赛186.可获得的最大点数;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 15:46
 */
public class test {

    public static void main(String[] args) {
        test s = new test();
        System.out.println(s);
        Thread thread = new Thread(() -> {
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(1);
            System.out.println(threadLocal.get());
            ThreadLocal threadLocal1 = new ThreadLocal();
            threadLocal1.set(2);
            System.out.println(threadLocal1.get());
        });
        thread.start();
    }
}
