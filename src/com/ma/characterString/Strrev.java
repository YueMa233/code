package com.ma.characterString;

/**
 * 题目：
 * 给定一个字符类型的数组chas,请在单词间做逆序调整。只要做到单词顺序逆序即可，对空格的位置没有太多
 * 的要求。
 * 举例：
 * 如果把chas看作字符串"dog loves pig",调整成"pig loves dog"。
 * 如果把chas看作字符串"I'am a student."调整成"student. a I'm"。
 * */

/**
 * 解答：
 * 首先把chas整体逆序。在逆序之后，遍历chas找到每一个单词，然后把每一个单词里的字符逆序即可。
 * 比如"dog loves pig"，先整体逆序变为"gip sevol god"，然后每个单词进行逆序处理就变为"pig loves dog"。
 * 逆序之后找到每一个单词的逻辑，做到不出错即可。
 */
public class Strrev {
    public static void reverse(char[] chas, int start, int end){
        char tmp = 0;
        while(start < end){
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }
    public static void rotateWord(char[] chas){
        if(chas == null || chas.length == 0){
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for(int i = 0; i < chas.length - 1; i++){
            if(chas[i] != ' '){
                l = i == 0 || chas[ i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if( l != -1 && r != -1){
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }
    public static void main(String[] args) {
        String str = "dog loves pig";
        char[] chas = str.toCharArray();
        rotateWord(chas);
        System.out.println(chas);

    }
}
