package 工厂设计模式.抽象工厂;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 13:14
 */
public class MemRequest implements Request{
    @Override
    public void getData() {
        System.out.println("mem");
    }
}
