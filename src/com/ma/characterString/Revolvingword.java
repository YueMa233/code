package com.ma.characterString;

/**
 * 题目：
 * 如果一个字符串str,把字符串str前面任意的部分挪到后面形成的字符串叫做str的旋转词。比如str="12345"、"23451"、
 * "34512"、和"51234"。
 * 给定两个字符串a和b，请判断a和b是否互为旋转词。
 */

/**
 * 举例：
 * a="cdab",b="abcd",返回true。
 * a="1ab2",b="ab12",返回false。
 * a="2ab1",b="ab12",返回true。
 */
/**
 * 解答：
 * 如果a和b的长度不一样，字符串a和b不可能互为旋转词。如果a和b长度一样，先生成一个大字符串b2,b2是两个字符串b拼在一起的
 * 结果，即String b2 = b + b。然后看b2中是否包含字符串a,如果包含，说明字符串a和b互为旋转词，否则说明两个字符串
 * 不为字符串。
 */
public class Revolvingword {
    public static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos < next.length){
            if(ms[pos - 1] == ms[cn]){
                next[pos++] = ++cn;

            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }
    public static int getindexOf(String s, String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while(si < ss.length && mi < ms.length){
            if(ss[si] == ms[mi]){
                si++;
                mi++;
            }else if(next[mi] == -1){
                si++;
            }else{
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }
    public static boolean isRotation(String a, String b){
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        String b2 = b + b;
        return getindexOf(b2,a) != -1;
    }
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdab";
        System.out.println(isRotation(a,b));
    }
}
