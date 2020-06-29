package 周赛189;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/17 10:31
 */
public class 在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int all = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                all++;
            }
        }
        return all;
    }
}
