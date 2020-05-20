package 任务调度;


import java.util.List;

public interface BusinessCore<T> {

    public void startNetWork(DataCallback dataCallback);

    public void endNetWork();

    public void sendCommand(T t);

//    public void singleMeasureStart(byte[] bytes, DataCallback dataCallback);//开启单频
//
//    public void singleMeasureStartLocal(byte[] bytes, DataCallback dataCallback);//开启单频本地数据
//
//    public void singleMeasureEnd();//结束单频
//
//    public void singleMeasureEndLocal();//结束单频本地数据
//
//    public void pdScanStart(byte[] bytes, DataCallback dataCallback);//开启频段
//
//    public void pdScanStartLocal(byte[] bytes, DataCallback dataCallback);//开启频段本地数据
//
//    public void pdScanEnd();//结束频段
//
//    public void pdScanEndLocal();//结束频段本地数据

    public void addTransaction(Transaction transaction);//添加任务

    public void cancelTransation(Transaction transaction);//取消某个任务

    public void clearAllTransaction();//删除所有任务

    public void addTransactions(List<Transaction> transactions);//批量的进行任务的添加

    public void pdScanParameterSet();
}
