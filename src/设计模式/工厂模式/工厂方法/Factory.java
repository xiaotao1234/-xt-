package 工厂设计模式.工厂方法;

import 工厂设计模式.抽象工厂.Request;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 11:24
 */
public interface Factory {
    Request createRequest();
}
