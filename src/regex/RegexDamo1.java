package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDamo1 {
    @Test
    public void test1() {
        String pattern = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher("1.2.3.4");
        if (m.matches()) {
            int count = m.groupCount();
            System.out.println(count);
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }
        m=r.matcher("2.2.2.255");
        System.out.println(m.matches());
    }
    @Test
    public void test2() {
        String reg = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String text = "1.2.3.4";
        //下面的正则表达式中共有四个捕获组：(<textarea.*?>)、(.*?)、(</textarea>)和整个匹配到的内容
        String reg2 = "(<textarea.*?>)(.*?)(</textarea>)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group(0)); // 整个匹配到的内容
            System.out.println(m.group(1)); // (<textarea.*?>)
            System.out.println(m.group(2)); // (.*?)
            System.out.println(m.group(3)); // (</textarea>)
        }

    }
}
