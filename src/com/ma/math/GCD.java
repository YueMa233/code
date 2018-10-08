package com.ma.math;

import java.util.Scanner;

/**
 * 题目：
 * 求p和q的最大公约数
 */
public class GCD {
    public static  int gcd(int p, int q){
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(gcd(p,q));
    }
}
