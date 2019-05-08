package capinfo.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StringTest {

    @Test
    public void testIsNullOrEmpty(){
        //判断是否为空
        System.out.println(Strings.isNullOrEmpty(""));
        //将空串转化为Null
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.nullToEmpty(null));

        //前缀匹配
        System.out.println(Strings.commonPrefix("aaab", "aac"));//"aa"否则返回""
        //后缀匹配
        System.out.println(Strings.commonSuffix("aaac", "aac"));//"aac"否则返回"

        //重复3次   源代码中  n <<= 1 与 n = n<<1
        System.out.println(Strings.repeat("hello",3));

        int minLength = 5;
        String padEndResult = Strings.padEnd("123", minLength, '0');
        System.out.println("padEndResult is " + padEndResult);

        String padStartResult = Strings.padStart("1", 2, '0');
        System.out.println("padStartResult is " + padStartResult);



    }
    @Test
    public void testFormat(){

        /**
         * 设置参数需要参考String.format
         * https://docs.oracle.com/javase/9/docs/api/java/util/Formatter.html#syntax
         */
        System.out.println(Strings.lenientFormat("Hi,%s","万岁"));

    }

    /**
     * 拆分字符串
     */
    @Test
    public void testSplitter(){

//        Iterable<String> splitResults = Splitter.onPattern("[,|，]{1,}")
//                .trimResults()
//                .omitEmptyStrings()
//                .split("hello,word,,世界，水平");



        List<String> splitResults = Splitter.onPattern("[,|，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .splitToList("hello,word,,世界，水平");


        for (String item : splitResults) {
            System.out.println(item);
        }
    }
    @Test
    public void testSplitterToMap(){

        Map<String,String> splitResults = Splitter.onPattern("[,|，]{1,}")
                .trimResults()
                .omitEmptyStrings().withKeyValueSeparator("=")
                .split("y=2,x=1,z=12");

        splitResults.forEach((s, s2) -> {
            System.out.println(s+"="+s2);

        });

    }
    @Test
    public void testCharMatcher(){

        //计算字符串指定字符的个数
        boolean matches = CharMatcher.inRange('0','9').matches('1');
        System.out.println(matches);
        //计算字符串指定字符的个数
        int countIn = CharMatcher.is('a').countIn("aadca");
        System.out.println(countIn);
        //移除字符串特定字符
        String s1 = CharMatcher.inRange('0','9').or(CharMatcher.whitespace()).removeFrom("123 fff 1dd");
        System.out.println("移除数字与空格："+s1);//fffdd
        //保留字符串特定字符
        String s2 = CharMatcher.inRange('0','9').retainFrom("123 fff1dd");
        System.out.println("保留数字："+s2);//1231

        System.out.println(Splitter.on(CharMatcher.inRange('0','9')).trimResults().omitEmptyStrings().splitToList("李陶琳0万岁-022哈哈2"));


    }

    /**
     * Google Guava提供了Joiner类专门用来连接String。
     *
     * 譬如说有个String数组，里面有"a","b","c"，我们可以通过使用StringBuilder来创建String "a,b,c"。
     *
     * Joiner提供了这一类的功能。
     */
    @Test
    public void testJoiner(){
        System.out.println(Joiner.on(";").skipNulls().join(new String[]{"a","b","c"}));

        Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println(joiner.join(new String[]{"a",null,"c"}));

    }




}
