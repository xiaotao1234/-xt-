package 装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/20 20:11
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
