package 其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/20 13:16
 * 1，2，3，4，5，6，7，8，9之间加加减乘除号使其结果为50
 */
public class 相加为定值1到9 {

    public static void main(String[] args) {
        相加为定值1到9 s = new 相加为定值1到9();
        s.get();
    }

    public List<List<Character>> get() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        dd(ints,1,1,new ArrayList<>());
        return lists;
    }

    List<List<Character>> lists = new ArrayList<>();

    public void dd(int[] ints, int position, int now, List<Character> characters) {
        if (position == 9) {
            if (now == 50) {
                lists.add(new ArrayList<>(characters));
            }
            return;
        }
        characters.add('+');
        dd(ints, position + 1, now + ints[position], characters);
        characters.remove(characters.size()-1);
        characters.add('-');
        dd(ints, position + 1, now - ints[position], characters);
        characters.remove(characters.size()-1);
        characters.add('*');
        dd(ints, position + 1, now * ints[position], characters);
        characters.remove(characters.size()-1);
        characters.add('/');
        dd(ints, position + 1, now / ints[position], characters);
        characters.remove(characters.size()-1);
    }
}
