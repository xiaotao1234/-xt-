package 贪心;

public class 使括号有效的最少添加 {

    public static void main(String[] args) {
        使括号有效的最少添加 s = new 使括号有效的最少添加();
        System.out.println(s.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        if (S == null || S == "") {
            return 0;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else if (S.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left+right;
    }
}
