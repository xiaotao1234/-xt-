package 工厂设计模式.抽象工厂;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 14:07
 */
public class ProcessMem implements Process{
    @Override
    public void getData() {
        System.out.println("内存数据处理");
    }
}
