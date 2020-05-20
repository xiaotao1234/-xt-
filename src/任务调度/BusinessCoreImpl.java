package 任务调度;

import 拓扑排序.课程表2;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusinessCoreImpl<T> implements BusinessCore<T> {

    public static void main(String[] args) {
        BusinessCoreImpl s = new BusinessCoreImpl(new TreeMap<>(), Executors.newScheduledThreadPool(5));
//        long time = System.currentTimeMillis();
//
//        for (int i = 1; i <= 8; i++) {
//            Transaction transaction1 = Factory.createTransaction(i);
//            s.addTransaction(transaction1);
//        }
//        s.addTransaction(Factory.createTransaction(2));
//        s.addTransaction(Factory.createTransaction(1));
//        System.out.println(System.currentTimeMillis()-time);
        Transaction transaction1 = Factory.createTransaction(1);
        Transaction transaction2 = Factory.createTransaction(2);
        Transaction transaction3 = Factory.createTransaction(3);
//        Transaction transaction3 = Factory.createTransaction(3);
//
//        s.addTransaction(transaction1);
        s.addTransaction(transaction2);
        s.addTransaction(transaction3);
        s.cancelTransation(transaction2);
        s.cancelTransation(transaction3);
    }

    TreeMap<Integer, Transaction> transactionTreeMap; //任务的集合
    //    List<DataProcess> dataProcesses;//数据处理算法
//    List<Job> jobs; //处于进行中的任务
//    JsonUtil jsonUtil;//格式转换工具
    ExecutorService executorService;
    Lock lock = new ReentrantLock();


    /**
     * @param
     * @return
     * @description 开启连接
     */
    @Override
    public void startNetWork(DataCallback dataCallback) {

    }

    public BusinessCoreImpl(TreeMap<Integer, Transaction> transactionTreeMap, ExecutorService executorService) {
        this.transactionTreeMap = transactionTreeMap;
        this.executorService = executorService;
    }

    /**
     * @param
     * @return
     * @description 关闭连接
     */
    @Override
    public void endNetWork() {

    }

    @Override
    public void sendCommand(T t) {

    }

    @Override
    public void addTransaction(Transaction transaction) {
//        synchronized (lock) {
//            lock.lock();
//            if (transactionTreeMap.containsKey(transaction.taskSetNumber)) {
//                add(transactionTreeMap.get(transaction.taskSetNumber), transaction, new ArrayList<>(transaction.preEventType));
//            } else{
//                transactionTreeMap.put(transaction.taskSetNumber,add(null,transaction,transaction.preEventType));
//            }
//            transaction.beAdd();
//            lock.notifyAll();
//        }
        synchronized (lock) {
            lock.lock();
            transaction.beAdd();
            if (transactionTreeMap.containsKey(transaction.taskSetNumber)) {
                transactionTreeMap.put(transaction.taskSetNumber, add(transactionTreeMap.get(transaction.taskSetNumber), transaction, new ArrayList<>(transaction.preEventType)));
            } else {
                transactionTreeMap.put(transaction.taskSetNumber, add(null, transaction, new ArrayList<>(transaction.preEventType)));
            }
            transaction.beAdd();
            lock.notifyAll();
        }
    }

    @Override
    public void cancelTransation(Transaction transaction) {
        synchronized (lock) {
            lock.lock();
            if (transactionTreeMap.containsKey(transaction.taskSetNumber)) {
                if (transactionTreeMap.get(transaction.taskSetNumber).next == null) {
                    transactionTreeMap.remove(transaction.taskSetNumber);
                } else {
                    Transaction transaction1 = transactionTreeMap.get(transaction.taskSetNumber);
                    if (transaction1 != null) {
                        Transaction transaction2 = delete(transaction1, transaction);
                        if (transaction2 == null) {
                            transactionTreeMap.remove(transaction.taskSetNumber);
                        } else {
                            transactionTreeMap.put(transaction.taskSetNumber, transaction2);
                        }
                    }
                }
            }
            transaction.beCancel();
            lock.notifyAll();
        }
    }

    public Transaction delete(Transaction transaction, Transaction target) {
        if (transaction == null) {
            return null;
        }
        if (transaction == target) {//找到任务，直接将任务从链表删除
            return transaction.next;
        }
        List<Integer> list = target.preEventType;
        if (list.contains(transaction.eventType)) {//若当前节点是目标任务的前驱任务，则将当前任务的引用计数减1
            transaction.ReferenceCount--;
            if (transaction.ReferenceCount == 0) {//若当前任务的引用数减小到了0，那么 代表该任务已经失去了运行的意义，直接从链中删除该任务。
                transaction = delete(transaction.next, target);
            } else {
                transaction.next = delete(transaction.next, target);
            }
        }
        return transaction;
    }

    public Transaction add(Transaction transaction, Transaction target, List<Integer> list) {
//        if (transaction == null) {
//            Transaction transaction1 = target;
//            if (list.size() != 0) {
//                for (int i = 0; i < list.size(); i++) {
//                    Transaction transaction2 = Factory.createTransaction(list.get(i));
//                    transaction2.beAdd();
//                    transaction1.next = transaction2;
//                    transaction1 = transaction1.next;
//                }
//            }
//            return target;
//        }
//        if (target.preEventType.contains(transaction.eventType)) {
//            transaction.ReferenceCount++;
//            list.remove(list.indexOf(transaction.eventType));
//        }
//        transaction.next = add(transaction.next, target, list);
//        return transaction;
        if (transaction == null) {
            Transaction transaction1 = target;
            if (list.size() != 0) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    Transaction transaction2 = Factory.createTransaction(list.get(i));
                    ++transaction2.ReferenceCount;
                    transaction2.beAdd();
                    transaction2.next = transaction1;
                    transaction1 = transaction2;
                }
            }
            return transaction1;
        }
        if (target.preEventType.contains(transaction.eventType)) {
            transaction.ReferenceCount++;
            list.remove(list.indexOf(transaction.eventType));
        }
        transaction.next = add(transaction.next, target, list);
        return transaction;
    }
//
//    public Transaction add(Transaction target) {
//        List<Integer> list = target.preEventType;
//        if (list.size() == 0) {
//            return target;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            target.next = add(Factory.createTransaction(list.get(i)));
//        }
//    }

    public Transaction findTransaction(Transaction transaction, Transaction target) {
        if (transaction == null) {
            return null;
        }
        if (transaction == target) {
            return transaction.next;
        }
        transaction.next = findTransaction(transaction.next, target);
        return transaction;
    }

    @Override
    public void clearAllTransaction() {
        lock.lock();
        Iterator iterator = transactionTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Transaction transaction = (Transaction) iterator.next();
            while (transaction != null) {
                transaction.beCancel();
                transaction = transaction.next;
            }
        }
        transactionTreeMap.clear();
        lock.notifyAll();
    }

    @Override
    public void addTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            addTransaction(transaction);
        }
    }

    @Override
    public void pdScanParameterSet() {

    }

    static class Factory {
        public static Transaction createTransaction(int type) {
            Transaction transaction = null;
            switch (type) {
                case 1:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(), 0);
                    break;
                case 2:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
                case 3:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
                case 4:
                    transaction = new VoiceParseTransaction(type, 4, new ArrayList<>(Arrays.asList(1, 2, 3)), 1);
                    break;
                case 5:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
                case 6:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
                case 7:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
                case 8:
                    transaction = new VoiceParseTransaction(type, 1, new ArrayList<>(Arrays.asList(1)), 1);
                    break;
            }
            return transaction;
        }
    }
}
