package 迪米特原则;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 13:40
 */
public class peopleB {
    public void doB() {
        System.out.println("B");
    }

    public peopleC peopleC;

    public peopleC getPeopleC() {
        return peopleC.get();
    }

    public void doc() {
        peopleC.get().doC();
    }
}
