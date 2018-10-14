package com.ma.bit;

import java.util.Scanner;

/**
 * 题目：
 * 给定一个32位整数n,可为0，可为正，也可以为负，返回该整数二进制表达式中1的个数。
 */
public class Count1 {
    //最简单解法。整数n每次进行无符号右移一位，检查最右边的bit是否为1来进行统计。
    public static int count1(int n){
        int res = 0;
        while (n != 0){
            res += n & 1;
        }
        return res;
    }
    //第二种方法每次抹去最右边的1。
    public static int count2(int n){
        int res = 0;
        while (n != 0){
            n &= (n-1);
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count1(n));
        System.out.println(count2(n));
    }
}
