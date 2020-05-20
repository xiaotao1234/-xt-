package 接口隔离原则;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 10:38
 */
//我们对接口的方法定义应该限定在这个接口的最小职责范伟内，即若为动物接口，我们就把他的接口的方法限制到他的动物相关的基本属性上
public interface Animal {
    public void kind();
    public void heigh();
    public void weight();
}
