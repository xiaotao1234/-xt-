package 任务调度;

import java.util.List;

public class VoiceParseTransaction<T> extends Transaction<T> {

    public VoiceParseTransaction(int eventType, int taskSetNumber, List<Integer> preEventType, int referenceCount) {
        super(eventType, taskSetNumber, preEventType, referenceCount);
    }

    @Override
    public T perform(T t) {
        return null;
    }

    @Override
    public void beCancel() {
        System.out.println("delete eventtype="+eventType);
    }

    @Override
    public void beAdd() {
        System.out.println("add eventtype="+eventType);
    }
}
