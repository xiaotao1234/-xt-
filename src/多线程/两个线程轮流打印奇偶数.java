package 多线程;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/5 18:08
 */
public class 两个线程轮流打印奇偶数 {

    public static void main(String[] args) {
        两个线程轮流打印奇偶数 s = new 两个线程轮流打印奇偶数();
        s.runThread();
    }

    volatile int flag=0;
    public void runThread() {
        Thread t1=new Thread(new Thread1());
        Thread t2=new Thread(new Thread2());
        t1.start();
        t2.start();
    }
    public class Thread1 implements Runnable{

        public void run() {
            int i=0;
            while(i<=99){
                if(flag==0)
                {
                    System.out.println("t1="+i+"flag="+flag);
                    i+=2;
                    flag=1;
                }
            }
        }

    }

    public class Thread2 implements Runnable{

        public void run() {
            int i=1;
            while(i<=99){
                if(flag==1)
                {
                    System.out.println("t2="+i+"flag="+flag);
                    i+=2;
                    flag=0;
                }
            }
        }

    }
}
