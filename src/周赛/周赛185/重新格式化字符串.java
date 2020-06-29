package 周赛185;

import 双周赛20.包含所有三种字符的子字符串数目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/19 10:30
 */
public class 重新格式化字符串 {

    public static void main(String[] args) {
        重新格式化字符串 s = new 重新格式化字符串();
        System.out.println(s.reformat("covid2019"));
    }
    public String reformat(String s) {
        List<Character> list = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            if (ss > 96) {
                list.add(ss);
            } else {
                list1.add(ss);
            }
        }
        if (Math.abs(list.size() - list1.size()) > 1) {
            return "";
        } else {
            String s1 = "";
            if (list.size() > list1.size()) {
                for (int j = 0; j < list1.size(); j++) {
                    s1 = s1 + list.get(j) + list1.get(j);
                }
                s1 = s1 + list.get(list.size() - 1);
                return s1;
            } else if (list.size() < list1.size()) {
                for (int j = 0; j < list.size(); j++) {
                    s1 = s1 + list1.get(j)+ list.get(j);
                }
                s1 = s1 + list1.get(list1.size() - 1);
                return s1;
            }else {
                for (int j = 0; j < list.size(); j++) {
                    s1 = s1 + list1.get(j)+ list.get(j);
                }
                return s1;
            }
        }
    }
}
