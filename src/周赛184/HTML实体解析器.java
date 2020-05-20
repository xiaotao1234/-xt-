package 周赛184;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/12 11:01
 */
public class HTML实体解析器 {

    public static void main(String[] args) {
        HTML实体解析器 s = new HTML实体解析器();

        System.out.println(s.entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
    public String entityParser(String text) {
        text = text.replace("&quot;","\"");
        text = text.replace("&apos;","\'");
        text = text.replace("&amp;","&");
        text = text.replace("&gt;",">");
        text = text.replace("&lt;","<");
        text = text.replace("&frasl;","/");
        return text;
    }

//    public String get(String s) {
//        String[] strings = new String[]{"&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
//        String flag = "";
//        for (int i = 0; i < s.length(); i++) {
//            if (i == 0) {
//                if (s.charAt(i) == '&') {
//                    int j = i;
//                    while (j < s.length()) {
//                        if (s.charAt(j) == ';') {
//                            flag = s.substring(i, j);
//                            if (flag.equals("quot")) {
//                                s.
//                            }
//                            return flag;
//                        }
//                    }
//                }
//            }
//        }
//        return flag;
//    }

}
