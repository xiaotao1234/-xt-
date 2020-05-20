package 迪米特原则;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 13:39
 */
//又叫最少知道原则，即让类持有其他最少的类以及对其他类保持最少的了解，最终达到降低类之间的耦合，达到高内聚低耦合的目的
public class peopleA {
    public void doA() {
        System.out.println("A");
    }

//    public void doX(peopleB peopleb) {
//        peopleC peopleC = peopleb.getPeopleC();
//        peopleC.doC();
//    }
//    不符合迪米特原则，因为现在在A中持有了C的引用

    public void dosome(peopleB peopleb) {
        peopleb.doc();//只持有b,告诉b，a让b帮自己调用c，这样可以避免由于c的变化波及到A，这里受影响的只被限制在最小范围内
    }
}
