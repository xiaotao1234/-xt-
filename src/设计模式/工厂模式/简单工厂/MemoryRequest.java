package 工厂设计模式.简单工厂;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 11:18
 */
public class MemoryRequest implements Request{
    @Override
    public void getData() {
        System.out.println("memory");
    }
}
