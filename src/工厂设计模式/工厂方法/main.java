package 工厂设计模式.工厂方法;

import 工厂设计模式.抽象工厂.Factory;
import 工厂设计模式.抽象工厂.Request;
import 工厂设计模式.抽象工厂.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 13:11
 */
public class main {
    public static void main(String[] args) {
        NetFactory factory = new NetFactory();
        NetRequest netRequest = (NetRequest) factory.createRequest();
        MemFactory factory1 = new MemFactory();
        MemRequest memRequest = (MemRequest) factory1.createRequest();

    }

    class clloction {
        List<Factory> factories = new ArrayList<>();
        List<Request> requests = new ArrayList<>();

        public void add(Factory factory) {
            factories.add(factory);
        }

        public void productRequest() {
            if (requests.size() != 0) requests.clear();
            for (Factory factory : factories) {
                requests.add(factory.createRequest());
            }
        }
    }

}
