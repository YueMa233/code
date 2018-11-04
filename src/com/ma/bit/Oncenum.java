package com.ma.bit;

import java.util.Scanner;

/**
 * 题目：
 * 给定一个整型数组arr和一个大于1的整数K。已知arr中只有1个数出现了1次，其他数都出现了K次，请返回只出现了1次的数。
 *
 * 解答：
 * 以下的例子是两个七进制数的无进位相加，即忽略进位的相加，比如：
 * 七进制数a：6 4 3 2 6 0 1
 * 七进制数a：3 4 5 0 1 1 1
 * 无进位相加结果：2 1 1 2 0 1 2
 * 可以看出，两个七进制的数a和b，在i位上无进位相加的结果就是（a(i)+b(i))%7。同理,K进制的两个数c和d,
 * 在i位
 * 上无进位相加的结果就是(c(i)+d(i))%K。那么K个相同的K进制数进行无进位相加，相加结果一定是每一位都是0的
 * K进位数。
 *
 * 理解了上面的过程之后，解这道题就变得容易了许多，首先设置一个变量eO,它是一个32位的K进制数，且每个位置
 * 上都是0,然后遍历arr，把遍历的每一个整数都转换为K进制的数，然后与eO进行无进位相加。遍历结束后，把32位
 * 的K进制数eORes转换为十进制整数，这就是我们想要的结果。因为K个相同的K进制数无进位相加，结果一定是每位
 * 上都是0的K进制数，所以只出现一次的那个数最终就会剩下来。
 */
public class Oncenum {
    public static int onceNum(int[] arr, int k){
        int[] eO = new int[32];
        for(int i = 0; i != arr.length; i++){
            setExclusiveOr(eO, arr[i], k);
        }
        int res = getNumFromKSysNum(eO,k);
        return res;
    }
    public static void setExclusiveOr(int[] eO, int value, int k){
        int[] curKSysNum = getKSysNumFromNum(value,k);
        for(int i = 0; i != eO.length; i++){
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }
    public static int[] getKSysNumFromNum(int value, int k){
        int[] res = new int[32];
        int index = 0;
        while(value != 0){
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }
    public static int getNumFromKSysNum(int[] eO, int k){
        int res = 0;
        for(int i = eO.length -1; i != -1; i--){
            res = res * k + eO[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,2,5,5,8,8,4,4,7,7,6,6,9,9};
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(onceNum(arr, k));

    }
}
