package 双周赛24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 23:04
 */
public class 长度为n的开心字符串中字典序第k小的字符串 {

    public static void main(String[] args) {
        长度为n的开心字符串中字典序第k小的字符串 s = new 长度为n的开心字符串中字典序第k小的字符串();
        System.out.println(s.getHappyString1(3, 9));
    }

    public String getHappyString2(int n, int k) {
        List<String> strings = new ArrayList<>();
        get(strings, new char[n], 0);
        if (k > strings.size()) {
            return "";
        }
        return strings.get(k - 1);
    }

    public void get(List<String> list11, char[] chars, int l) {
        if (l == chars.length) {
            list11.add(new String(chars));
            return;
        }
        char[] a = new char[]{'a', 'b', 'c'};
        for (char s : a) {
            if (l > 0 && chars[l] == chars[l - 1]) {
                continue;
            }
            get(list11, chars, l + 1);
        }
    }

    public String getHappyString(int n, int k) {
        if (n == 1) {
            if (k == 1) {
                return "a";
            } else if (k == 2) {
                return "b";
            } else if (k == 3) {
                return "c";
            }
        }
        int length = 3;
        int s = n;
        while (s > 1) {
            length = length * 2;
            s--;
        }
        if (k > length) {
            return "";
        }
        int index = k / (length / 3);
        int sen = k % (length / 3);
        if (sen == 0) {
            sen++;
        }
        TreeNode treeNode1 = new TreeNode('a');
        TreeNode treeNode2 = new TreeNode('b');
        TreeNode treeNode3 = new TreeNode('c');
        if (index == 0) {
            get(treeNode1, n, 0);
            get1(treeNode1, n, "a");
            return list11.get(sen - 1);
        } else if (index == 1) {
            get(treeNode2, n, 0);
            get1(treeNode2, n, "b");
            return list11.get(sen - 1);
        } else {
            get(treeNode3, n, 0);
            get1(treeNode3, n, "c");
            return list11.get(sen - 1);
        }
    }

    public void get1(TreeNode treeNode, int n, String strings) {
        if (strings.length() == n) {
            list11.add(strings);
            return;
        } else {
            get1(treeNode.left, n, strings + treeNode.left.s);
            get1(treeNode.right, n, strings + treeNode.right.s);
        }
    }

    List<String> list11 = new ArrayList<>();

    public void get(TreeNode treeNode, int cen, int now) {
        if (now == cen) {
            return;
        } else {
            if (treeNode.s == 'a') {
                treeNode.left = new TreeNode('b');
                treeNode.right = new TreeNode('c');
            } else if (treeNode.s == 'b') {
                treeNode.left = new TreeNode('a');
                treeNode.right = new TreeNode('c');
            } else {
                treeNode.left = new TreeNode('a');
                treeNode.right = new TreeNode('b');
            }
            get(treeNode.left, cen, now + 1);
            get(treeNode.right, cen, now + 1);
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        char s;

        public TreeNode(char s) {
            this.s = s;
        }
    }

    public String getHappyString1(int n, int k) {
        List<String> list = new ArrayList<>();
        dfs(list, new char[n], 0);
        if (k - 1 >= list.size()) return "";
        return list.get(k - 1);
    }

    void dfs(List<String> list, char[] chars, int pos) {
        int n = chars.length;
        if (pos >= n) {
            list.add(String.valueOf(chars));
            return;
        }
        char[] cc = {'a', 'b', 'c'};

        for (char c : cc)//添加第i位的字符，按照a,b,c依次添加，若尾巴两个元素相等了，就不进行递归，因为只有在递归的结束条件处才去添加子项
        //因此这里不向下递归就相当于排除了此项条件，
        {
            chars[pos] = c;
            if (pos > 0 && chars[pos - 1] == chars[pos]) continue;
            dfs(list, chars, pos + 1);
        }
    }
}
