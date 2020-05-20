package 迪米特原则;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 13:40
 */
public class peopleC {
    public void doC() {
        System.out.println("C");
    }

    public peopleC get() {
        return new peopleC();
    }
}
