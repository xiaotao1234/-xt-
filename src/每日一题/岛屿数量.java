package 每日一题;

import 双周赛20.包含所有三种字符的子字符串数目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/20 13:35
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        岛屿数量 s = new 岛屿数量();
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] is = new boolean[grid.length][grid[0].length];
        int all = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!is[i][j] && grid[i][j] == '1') {
                    List<node> list = new ArrayList<>();
                    list.add(new node(i, j));
                    is[i][j] = true;
                    while (list.size() != 0) {
                        node node1 = list.remove(0);
                        if (node1.x + 1 >= 0 && node1.x + 1 < grid.length && grid[node1.x + 1][node1.y] == '1' && !is[node1.x + 1][node1.y]) {
                            list.add(new node(node1.x + 1, node1.y));
                            is[node1.x + 1][node1.y] = true;
                        }
                        if (node1.y + 1 >= 0 && node1.y + 1 < grid[0].length && grid[node1.x][node1.y + 1] == '1' && !is[node1.x][node1.y + 1]) {
                            list.add(new node(node1.x, node1.y + 1));
                            is[node1.x][node1.y+1] = true;
                        }
                        if (node1.x - 1 >= 0 && node1.x - 1 < grid.length && grid[node1.x - 1][node1.y] == '1' && !is[node1.x - 1][node1.y]) {
                            list.add(new node(node1.x - 1, node1.y));
                            is[node1.x - 1][node1.y] = true;
                        }
                        if (node1.y - 1 >= 0 && node1.y - 1 < grid[0].length && grid[node1.x][node1.y - 1] == '1' && !is[node1.x][node1.y - 1]) {
                            list.add(new node(node1.x, node1.y - 1));
                            is[node1.x][node1.y-1] = true;
                        }
                    }
                    all++;
                }
            }
        }
        return all;
    }

    class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
