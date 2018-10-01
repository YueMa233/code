package com.ma.characterString;

/**
 * 题目：
 * 给定三个字符串 str、from和to,已知from字符串中无重复子串，把str中所有的from子串全部替换为to字符串，对连续出现的部分要求只替换成一个to字符串，返回最终的结果字符串。
 *
 * 举例:
 * str = “123abc”,from  = "abc",to = "4567",返回“1234567”。
 * str = “123”，from = "abc"，to = “456”，返回“123”。
 * str =  "123abcabc",from = "abc", to ="X",返回“123X”。
 *
 * 解答：
 * 如果把str看作字符类的数组，首先把str中from部分所有的字符编码设置为0，比如：str = “12abcabca4”,
 * from = “abc”,处理后str为[‘1’，‘2，’‘0’，‘0’‘0，’‘0’，‘0’，‘0’，‘a’,‘4']。
 * 1.生成整型变量match，表示目前匹配到from字符串到什么位置，初始时，match = 0。
 * 2.从左到右遍历str中每个字符串，假设当前遍历到str[i]。
 * 3.如果str[i] == from[match]。如果match是from最后一个字符的位置，说明在str中发现了from字符串，则从i位置向
 * 左移动m个位置，都把字符编码设为0，m为from的长度，设置完毕后令match = 0。如果match不是from最后一个字符的
 * 位置，令match++。继续遍历下一个字符串。
 * 4. 如果str[i] != from[match],说明匹配失败，令match = 0，即回到from开头重新匹配。此时如果str[i] == from[0]，
 * 从当前字符串开始重新匹配过程，否则继续遍历str下一个字符。
 */
public class Replace {
    public static String replace(String str, String from, String to){
        if(str == null || from == null || str.equals("") || from.equals("")){
            return str;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for(int i = 0;  i < chas.length; i++){
            if(chas[i] == chaf[match++]){
                if(match == chaf.length){
                    clear(chas, i, chaf.length);
                }
                match = 0;
            }else{
                if(chas[i] == chaf[0]){
                    i--;
                }
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for(int i = 0; i < chas.length; i++){
            if(chas[i] != 0){
                cur = cur + String.valueOf(chas[i]);
            }
            if(chas[i] == 0 && (i == 0 || chas[i - 1] != 0)){
                res = res + cur + to;
                cur = "";
            }
        }
        if(!cur.equals("")){
            res = res + cur;
        }
        return res;
    }
    public static void clear(char[] chas, int end, int len){
        while(len-- != 0){
            chas[end--] = 0;
        }
    }
    public static void main(String[] args) {
        String str = "123abc";
        String from = "abc";
        String to = "4567";
        String after = replace(str, from, to);
        System.out.println(after);
    }
}
