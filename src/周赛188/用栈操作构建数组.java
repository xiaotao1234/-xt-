package 周赛188;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/10 10:30
 */
public class 用栈操作构建数组 {

    public static void main(String[] args) {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(classLoader.getParent());
//        System.out.println(classLoader.getParent().getParent());
//        System.out.println(classLoader);
        用栈操作构建数组 s = new 用栈操作构建数组();
        System.out.println(s.buildArray(new int[]{1, 3}, 3));
    }


    public List<String> buildArray(int[] target, int n) {
        List<String> strings = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i == target[j]) {
                strings.add("Push");
            } else {
                strings.add("Push");
                strings.add("Pop");
            }
            j++;
        }
        return strings;
    }
}
