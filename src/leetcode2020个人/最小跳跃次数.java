package leetcode2020个人;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 15:38
 */
public class 最小跳跃次数 {
    public int minJump(int[] jump) {
        int[] set = new int[jump.length];
        Arrays.fill(set, 0);
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        while (true) {
            for (int s : set1) {
                set[set[s] + s] = Math.min(set[set[s] + s], set[s] + 1);
            }
        }
    }

    public int minJump1(int[] jump) {
        int n = jump.length;
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 1;
        int min = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int pre = queue.poll();
                int next = pre + jump[pre];
                if (next >= n) return ans;
                else if (!visit[next]) {
                    queue.offer(next);
                    visit[next] = true;
                }
                for (int j = min; j < pre; ++j) {
                    if (!visit[j]) {
                        queue.offer(j);
                        visit[j] = true;
                    }
                }
                min = Math.max(min, pre);
            }
            ++ans;
        }
        return ans;
    }

    public int minJump2(int[] jump) {
        boolean[] s = new boolean[jump.length];
        Queue<Integer> integers = new LinkedBlockingQueue<>();
        integers.add(0);
        int min = 1;//未遍历到的左边界
        int ans = 1;//跳跃次数
        while (integers.size() > 0) {
            int size = integers.size();
            for (int i = 0; i < size; i++) {
                int index = integers.poll();
                int next = jump[index] + index;
                if (next > jump.length) {
                    return ans;
                } else if (!s[next]) {
                    integers.add(next);
                    s[next] = true;
                }
                for (int j = min; j < index; j++) {
                    if (!s[j]) {
                        integers.add(j);
                        s[j] = true;
                    }
                }
                min = Math.min(min, index);
            }
            ++ans;
        }
        return ans;
    }
}
