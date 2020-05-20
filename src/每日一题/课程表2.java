package 每日一题;

import 零一背包问题.背包1;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/17 10:21
 */
public class 课程表2 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        for (int[] ints : prerequisites) {
            if (listMap.containsKey(ints[0])) {
                listMap.get(ints[0]).add(ints[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                listMap.put(ints[0], list);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!listMap.containsKey(i)) {
                list.add(i);
            }
        }
        int num = 0;
        while (list.size() < numCourses && list.size() > num) {
            num = list.size();
            for (int i : listMap.keySet()) {
                List<Integer> list1 = listMap.get(i);
                if (list1.size() != 0) {
                    List<Integer> list2 = new ArrayList<>();
                    for (int j : list) {
                        if (list1.contains(j)) {
                            list1.remove(list1.indexOf(j));
                            if (list1.size() == 0) {
                                list2.add(i);
                            }
                        }
                    }
                    list.addAll(list2);
                }
            }
        }
        if(list.size()<numCourses){
            return new int[0];
        }
        int s[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            s[i] = list.get(i);
        }
        return s;
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // [1,0] 0 -> 1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        课程表2 s = new 课程表2();
        s.findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});
    }

//    public void bebao() {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(5, 5);
//        treeMap.put(2, 2);
//        treeMap.put(4, 4);
//        treeMap.put(1, 1);
//        treeMap.put(0, 0);
//        Iterator iterator = treeMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println(entry.getValue());
//        }
//    }
}
