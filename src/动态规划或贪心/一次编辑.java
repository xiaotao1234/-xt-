package 动态规划或贪心;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 10:01
 */
public class 一次编辑 {

    public static void main(String[] args) {
        一次编辑 s = new 一次编辑();
        s.oneEditAway("a", "ab");
    }


    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= second.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i][j-1] + 1));
                }
            }
        }
        if (dp[first.length()][second.length()] <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean oneEditAway1(String first, String second) {//因为只允许变换一次否则直接失败，避免dp
        //判断长度差别是否满足一位以内
        int a=first.length()-second.length();
        if (a>1||a<-1){
            return false;
        }
        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        //只能跳过一次
        boolean hasContinue=false;
        for (int i = 0,j=0; i < chars1.length&&j<chars2.length; i++,j++) {
            if (chars1[i]==chars2[j]){
                continue;
            }else if(hasContinue){
                return false;//如果当前不相等，且前面已经进行了变换
            }
            if (a==1){//能够执行到这里代表进行了一次的变换
                j--;//chars1长度比chars2大1，那么变换的操作肯定是将chars1删除一个字符，那么这里在删除之后，需要将前一个指针回溯一个
            }else if(a==-1){
                i--;//chars1长度比chars2小1
            }
            hasContinue=true;
        }
        return true;
    }
}
