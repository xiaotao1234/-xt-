package 接口隔离原则;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 10:22
 */
public interface doWork {//只提供了最通用的接口方法，而把那些有的实现有有的实现没有的方法在子接口中去声明
    //好处有避免了
    public void gotowork();
    public void dosomething();
    public void sleeplaunch();
    public void gohome();
}
