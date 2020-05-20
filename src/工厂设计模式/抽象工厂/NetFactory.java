package 工厂设计模式.抽象工厂;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 11:27
 */
public class NetFactory implements Factory{
    @Override
    public Request createRequest() {
        return new NetRequest();
    }

    @Override
    public Process createProcess() {
        return new ProcessNet();
    }
}
