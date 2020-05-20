package 工厂设计模式.抽象工厂;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 13:11
 */
public class main {
    public static void main(String[] args) {
        Factory factorynet = new NetFactory();
        Factory factorymem = new MemFactory();
        productRequest(factorynet);
        productRequest(factorymem);
    }

    public static void productRequest(Factory factory1) {
        Request request = factory1.createRequest();
        request.getData();
        Process process = factory1.createProcess();
        process.getData();
    }

    static class clloction {
        List<Factory> factories = new ArrayList<>();
        List<Request> requests = new ArrayList<>();
        List<Process> processes = new ArrayList<>();

        public void add(Factory factory) {
            factories.add(factory);
        }

        public void productRequest(Factory factory1) {
            if (requests.size() != 0) requests.clear();
            if (processes.size() != 0) processes.clear();
//            for (Factory factory : factories) {
            Request request = factory1.createRequest();
            request.getData();
            Process process = factory1.createProcess();
            process.getData();
                requests.add(factory1.createRequest());
                processes.add(factory1.createProcess());
//            }
        }
    }

}
