package 周赛189;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/17 10:58
 */
public class 收藏清单 {

    public static void main(String[] args) {
        收藏清单 s = new 收藏清单();
        List<List<String>> ss = new ArrayList<>();
        List<String> string1 = new ArrayList<>();
        List<String> string2 = new ArrayList<>();
        List<String> string3 = new ArrayList<>();
        List<String> string4 = new ArrayList<>();
        List<String> string5 = new ArrayList<>();
        string1.add("leetcode");
        string1.add("google");
        string1.add("facebook");
        string2.add("google");
        string2.add("microsoft");
        string3.add("google");
        string3.add("facebook");
        string4.add("google");
        string5.add("amazon");
        ss.add(string1);
        ss.add(string2);
        ss.add(string3);
        ss.add(string4);
        ss.add(string5);
        System.out.println(s.peopleIndexes(ss));
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> strings = favoriteCompanies.get(i);
            for (String s : strings) {
                if (map.containsKey(s)) {
                    map.get(s).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(s, list);
                }
            }
        }
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> strings = favoriteCompanies.get(i);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                list.add(j);
            }
            for (String s : strings) {
                List<Integer> list1 = map.get(s);
                List<Integer> list2 = new ArrayList<>();
                for (int ss : list1) {
                    if (list.contains(ss) && ss!=i)
                        list2.add(ss);
                }
                list = list2;
            }
            if (list.size() == 0) {
                list3.add(i);
            }
        }
        return list3;
    }

    public List<Integer> peopleIndexes1(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for (List<String> f : favoriteCompanies) {
            int all = 0;
            for (List<String> s : favoriteCompanies) {
                if (s.size() <= f.size()) {
                    all++;
                    continue;
                }
                boolean is = true;
                Set<String> strings = new HashSet<>(s);
                for (String st : f) {
                    if (!strings.contains(st)) {
                        is = false;
                        break;
                    }
                }
                if (is) {
                    break;
                }
                //不能break 要全部
                all++;
            }
            if (all == favoriteCompanies.size()) {
                res.add(i);
            }
            i++;
        }
        return res;

    }
}
