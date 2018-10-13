package com.ma.bit;

/**
 * 题目：
 * 在一个数组中只有一个数出现了一次 其他数出现两次 请找出那个只出现一次的数字
 *
 * 解答：
 * 整数n与0异或的结果是n。n与n异或的结果是0。
 */
public class GetOnlyOne {
    public static int getNumber(int[] array){
        int flag = 0;
        for(int i : array){
            flag = flag ^ i;
        }
        return flag;
    }
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,5,5};
        System.out.println(getNumber(array));
    }
}
