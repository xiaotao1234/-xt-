package 周赛185;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/19 10:41
 */
public class 点菜展示表 {

    public static void main(String[] args) {
        点菜展示表 s = new 点菜展示表();
//        System.out.println(s.displayTable());
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("Table");
        for (List<String> stringList : orders) {
            if (map.containsKey(Integer.parseInt(stringList.get(1)))) {
                Map<String, Integer> stringIntegerMap = map.get(stringList.get(1));
                if (stringIntegerMap.containsKey(stringList.get(2))) {
                    stringIntegerMap.put(stringList.get(2), stringIntegerMap.get(stringList.get(2) + 1));
                } else {
                    stringIntegerMap.put(stringList.get(1), 1);
                    list.add(stringList.get(2));
                }
            } else {
                Map<String, Integer> stringIntegerMap = new HashMap<>();
                stringIntegerMap.put(stringList.get(2), 1);
                list.add(stringList.get(2));
                map.put(Integer.valueOf(stringList.get(1)), stringIntegerMap);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        for (int i = 0; i <= 500; i++) {
            if (map.containsKey(i)) {
                Map<String, Integer> stringIntegerMap = map.get(i);
                List<String> strings = new ArrayList<>();
                strings.add(String.valueOf(i));
                for (String s : list) {
                    int num = 0;
                    if (stringIntegerMap.containsKey(s)) {
                        num = stringIntegerMap.get(s);
                    }
                    strings.add(String.valueOf(num));
                }
                lists.add(strings);
            }
        }
        return lists;
    }
}
