package com.ma.characterString;

/**
 * 题目：
 * 给定一个字符串类型的数组chas[],chas[]右半边全是空字符，左半区不含有空字符。现在想在左半区中所有的空格字符替换为“%20”，假设chas[]右半区足够大，可以满足替换后所需要的空间，请完成函数。
 *
 * 举例：
 * 如果把chas[]左半区看作字符串“a b  c”，假设chas[]右半区足够大替换后chas[]的左半区为“a%20b%20%20c”。
 *
 * 解答：
 * 遍历一遍可以得到两个信息：1.chas[]左半区有多大，记为len，2.空格数有多少，记为num，那么替换后长度为len+num*2。
 * 接下来从最后一位开始复制。
 */
public class Replace2 {
    public static void replace(char[] chas){
        if(chas == null || chas.length == 0){
            return;
        }
        int len = 0;
        int num = 0;
        for(len = 0; len < chas.length && chas[len] != 0; len++){
            if(chas[len] == ' '){
                num++;
            }
        }
        int j = len + num * 2;
        for(int i = len; i > -1; i--){
            if(chas[i] != ' '){
                chas[j--] = chas[i];
            }else{
                chas[j--] ='0';
                chas[j--] ='2';
                chas[j--] ='%';
            }
        }
    }
    public static void main(String[] args) {

    }
}
