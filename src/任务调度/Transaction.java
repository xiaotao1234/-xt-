package 任务调度;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Transaction<T> {

    int eventType;//任务类型,唯一标识任务

    int taskSetNumber;//任务组号，-5到5，数字越小优先级越高，任务越先被调度执行/任务组

    List<Integer> preEventType;//前驱事件，用于建立整个事件族的拓扑结构

    int ReferenceCount;

    Transaction next;

    public Transaction(int eventType, int taskSetNumber, List<Integer> preEventType, int referenceCount) {
        this.eventType = eventType;
        this.taskSetNumber = taskSetNumber;
        this.preEventType = preEventType;
        ReferenceCount = referenceCount;
    }

    public abstract T perform(T t);//业务处理

    public void work(T t) {
        T t1 = perform(t);
        if (next != null) {
            next.work(t1);
        }
    }

    public abstract void beCancel();

    public abstract void beAdd();

}












