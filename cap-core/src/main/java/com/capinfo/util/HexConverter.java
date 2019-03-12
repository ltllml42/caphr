package com.capinfo.util;

import java.util.HashMap;


import java.util.Stack;

public class HexConverter {
    /**
     * 进制转换的工具类 注意：只能实现36进制之内的进制之间的转换
     *
     * @author Gcl
     *
     */

    /**
     * 私有构造方法是为了不让创建该类的对象， 作为一个工具类，
     * 只需要用类名直接调用方法就可以了，不需要创建对象
     */
    private HexConverter() {
    }

    /**
     * 初始化一个字符串，让0-9依次对应0-9，让a-z依次对应10-35,共有36个不同的字符
     * 所以,只能实现36进制之内的进制之间的转换
     * N进制的数可以用0~(N-1)的数表示，超过9的用字母A-F。
     */
    private static String initNum = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 其他进制转为10进制，采用按权展开的方法
     *
     * @param number 只传该进制的有效数值进来，例如，十六进制的0x1a,则,只需要传1a就可以了。
     *               这个参数采用String类型是因为,当进制大于十时,
     *               则该进制的表示形式中存在非数字的字符,例如,十六进制中的A代表十进制的10
     * @param N      你传进来的是N进制的数据
     * @return 十进制数值
     */
    public static long N_to_10(String number, int N) {

        if (N < 1) {
            System.out.println("必须是大于1的进制满足");
            System.exit(0);
        } else if (N > 37) {
            System.out.println("不能处理大于36进制的计算");
            System.exit(0);
        }

        // 如果传进来的int N本身就是要求转换为十进制，则直接返回输入的String number
        if (N == 10) {
            return Long.parseLong(number);
        }

        // 这里把输入的参数转换成小写是因为，在进制中，当大于9后，用英文字母a-z(或A-Z)依次表示
        // 且不区分大小写,例如,大写A和小写a都表示十进制数值10
        String numberToLowerCase = number.toLowerCase();
        char ch[] = numberToLowerCase.toCharArray();

        int len = ch.length;
        long result = 0;

        // 进制N的0次方
        long base = 1;
        // 采用，从低位到高位按权展开的方法
        // int i = len - 1 表示是从低位开始
        for (int i = len - 1; i >= 0; i--) {
            // 获取该位上的字符表示的数值，
            // 当大于9后，用英文字母a-z(或A-Z)依次表示，注意，不区分大小写，
            // 例如，大写A和小写a都表示十进制数值10
            int index = initNum.indexOf(ch[i]);

            // 该位上的数值，即index,乘以进制N的次方,即base
            result += index * base;

            // 即，权值依次增加，进制N的1次方，2次方，3次方...(len-1)次方
            base *= N;
        }
        return result;
    }

    /**
     * 初始化一个字符串，让0-9依次对应0-9，让a-z依次对应10-35,共有36个不同的字符
     * 所以,只能实现36进制之内的进制之间的转换
     * N进制的数可以用0~(N-1)的数表示，超过9的用字母A-F。
     */
    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 10进制转为其他进制，采用的方法是：除留取余，逆序排列
     *
     * @param number 十进制数值
     * @param N      要转换成几进制
     * @return N进制数值
     */
    public static String _10_to_N(long number, int N) {
        if (N < 1) {
            System.out.println("必须是大于1的进制满足");
            System.exit(0);
        } else if (N > 37) {
            System.out.println("不能处理大于36进制的计算");
            System.exit(0);
        }

        Long rest = number;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            /*
             * public int intValue() { return (int)value; }
             *
             * new Long((rest % N)).intValue()这个代码就是取余后转换成int
             *
             * array[new Long((rest % N)).intValue()]这行代码就是取出余数对应的值
             *
             * 余数进栈，然后逆序输出
             */
            stack.add(array[new Long((rest % N)).intValue()]);
            // 取商
            rest = rest / N;
        }
        // 逆序输出上面计算求出的余数
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}

