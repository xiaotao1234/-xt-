package 工厂设计模式.简单工厂;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 11:13
 */
public class NetworkRequest implements Request{
    @Override
    public void getData() {
        System.out.println("net");
    }
}
