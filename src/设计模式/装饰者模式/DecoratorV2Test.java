package 装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/20 20:12
 */
public class DecoratorV2Test {
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc()+" 销售价格:"+aBattercake.cost());

    }
}
