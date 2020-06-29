package 周赛186;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 11:18
 */
public class 可获得的最大点数 {

    public static void main(String[] args) {
        可获得的最大点数 s = new 可获得的最大点数();
        System.out.println(s.maxScore(new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30}, 8));
    }

    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int left = addall(cardPoints, 0, k - 1);
        int right = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, left + right);
            left = left - (cardPoints[k - i - 1]);
            right = right + (cardPoints[cardPoints.length - i - 1]);
        }
        max = Math.max(max, left + right);
        return max;
    }

    public int addall(int[] car, int left, int right) {
        if (left > right) {
            return 0;
        }
        int all = 0;
        for (int i = left; i <= right; i++) {
            all = all + car[i];
        }
        return all;
    }
}
