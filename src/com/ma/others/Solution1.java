package com.ma.others;
/**
 * 题目：
 * 给定一个整数n,返回从1到n的数字中1出现的次数。
 *
 * 例如：
 * n=5,1~n为1,2,3,4,5。那么1出现1次所以返回1。
 * n=11,1~n为1,2,3,4,5,6,7,8,9,10,11。那么1出现的次数为1（1,10,11）返回4。
 */

import java.util.Scanner;

public class Solution1 {
    public static int solution1(int num){
        if(num < 1){
            return 0;
        }
        int count = 0;
        for(int i = 1; i != num + 1; i++){
            count += get1Nums(i);
        }
        return count;
    }
    public static int get1Nums(int i){
        int res = 0;
        while(i != 0){
            if(i % 10 == 1){
                res++;
            }
            i /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution1(n));
    }
}
