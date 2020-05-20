package 贪心;

//给定两个整数 A 和 B，返回任意字符串 S，要求满足：
//
//S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
//子串 'aaa' 没有出现在 S 中；
//子串 'bbb' 没有出现在 S 中。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 不含AAA或BBB的字符串 {

    public static void main(String[] args) {
        不含AAA或BBB的字符串 s = new 不含AAA或BBB的字符串();
        System.out.println(s.strWithout3a3b(4, 1));
    }

    public String strWithout3a3b(int A, int B) {
        String s = "";
        char last;
        if (A >= B) {
            last = 'a';
        } else {
            last = 'b';
        }
        while (A != 0 || B != 0) {
            if (s != "") {
                last = s.charAt(s.length() - 1);
            }
            if (A >= B && last == 'b') {
                s = s + "a";
                A--;
                if (A > 0) {
                    A--;
                    s = s + "a";
                    if (B > 0) {
                        B--;
                        s = s + "b";
                    }
                }
            } else if (A >= B && last == 'a') {
                A--;
                s = s + "a";
            } else if (A < B && last == 'b') {
                B--;
                s = s + "b";
            } else if (A < B && last == 'a') {
                B--;
                s = s + "b";
                if (B > 0) {
                    B--;
                    s = s + "b";
                    if (A > 0) {
                        A--;
                        s = s + "a";
                    }
                }
            }
        }
        return s;
    }

    public String strWithout3a3b2(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int length = stringBuilder.length();
            if (length > 1 && stringBuilder.charAt(length - 1) == stringBuilder.charAt(length - 2)) {
                if (stringBuilder.charAt(length - 1) != 'a') {
                    writeA = true;
                }
            } else {
                if (A > B) {
                    writeA = true;
                }
            }
            if (writeA) {
                A--;
                stringBuilder.append('a');
            } else {
                B--;
                stringBuilder.append('b');
            }
        }
        return String.valueOf(stringBuilder);
    }


    public String strWithout3a3b1(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L - 1) == ans.charAt(L - 2)) {
                if (ans.charAt(L - 1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb/solution/bu-han-aaa-huo-bbb-de-zi-fu-chuan-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
