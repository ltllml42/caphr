package capinfo.guava;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class OrderingTest {
    @Test
    public void testStaticOrdering() {

        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("6");
        list.add("9");
        list.add("8");
        list.add("4");
        list.add("10");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));


    }


    @Test
    public void testStaticOrderingMethod() {

        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("6");
        list.add("9");
        list.add("8");
        list.add("4");
        list.add("10");

        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        naturalOrdering = naturalOrdering.compound(new Comparator<String>() {
            /**
             * Ints.tryParse("10")
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(String o1, String o2) {

                Integer i1 = Ints.tryParse(o1);
                Integer i2 = Ints.tryParse(o2);
                if (i1 == null || i2 == null) {
                    return -1;
                }
                return ComparisonChain.start().compare(i1, i2).result();

            }
        });
        System.out.println(naturalOrdering);
        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("顺序翻转:" + naturalOrdering.reverse().sortedCopy(list));

        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));
    }

    /**
     * 需求  数字按照大小进行排序，非数字排在数字后面，最后是空字符串
     * <p>
     * 按照数字从小到大进行排序，空向后排序
     */
    @Test
    public void naturalTest() {
        List<String> list = Lists.newArrayList("你好", "0", "2", "3", "33", "4",
                "1000", null, "null", "hehe", "啦啦", "12");
        Ordering<String> comp = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                for (String s : list) {
                    System.out.print(s + " ");
                }
                System.out.println();
                Integer l1 = Ints.tryParse(left);
                Integer r1 = Ints.tryParse(right);
                if (l1 == null && r1 == null) {
                    return 0;
                }
                if (l1 == null) {
                    return 1;
                }
                if (r1 == null) {
                    return -1;
                }
                return Ints.compare(l1, r1);
            }
        };
        list.sort(comp.nullsLast());//遇到空需要放后面处理
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    /**
     * 按照中文首字母进行排序
     */

    @Test
    public void naturalTest1() {

        List<String> list = Lists.newArrayList("舒淇", "安室奈美惠", "刘德华", "孙本樱", "漩涡鸣人", "猪刚鬣",
                "周星驰", "朱茵", "布莱尼", "小李子", "叶赫那拉氏", "王建平");
        Ordering<String> stringOrdering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Collator.getInstance(Locale.CHINA).compare(left, right);
            }
        };
        //Collator 类执行区分语言环境的 String 比较。使用此类可为自然语言文本构建搜索和排序例程
        list.sort(stringOrdering.nullsLast());
        System.out.println(list.toString());
    }

    public void testPerson() {





    }


}
