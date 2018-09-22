package com.ma.characterString;

/**
 * 题目：
 * 给定两个字符串 str1 和 str2，返回两个字符串的最长公共子串。
 *举例：
 * str1 = "1AB2345CD"，str2 = "12345EF"，返回"2345"。
 */

/**
 * 解答：
 * 经典动态规划的方法可以做到时间复杂度为O(M*N)，额外空间复杂度为O(M*N)。
 * 首先需要生成动态规划表。生成大小为M*N的矩阵dp，行数为M,列数为N。dp[i][j]的含义是：
 * 在必须把str1[i]和str2[j]当作公共子串最后一个字符的情况下，最长公共子串能有多长。
 * 比如，str1 = "A1234B"，str2 = "CD1234"，dp[3][4]的含义是在必须把str1[3]和str2[4]当作公共子串
 * 最长能有多长。这时候最长公共子串为"123"所以dp[3][4]为3。
 * 再如，str1 = "A12E4B",str2 = "CD12F4",dp[3][4]的含义是必须把str1[3]和str2[4]当作公共子串的最后一个
 * 字符的情况下，公共子串能有多长。显然这种情况不可能构成公共子串。dp[3][4]为0。
 */

/**
 * 1.矩阵dp第一列即dp[0..M-1][0]。对某一个位置（i,0）来说，如果str[i] == str2[0]，令dp[i][0] = 1,
 * 否则令dp[i][0] = 0。
 * 比如str1 = "ABAC" str2 = "A"。dp矩阵第一列上的值依次为dp[0][0] = 1,dp[2][0] = 0,dp[3][0] = 1,
 * dp[3][0] = 0。
 * 2.矩阵dp第一行dp[0][0...N-1]与步骤1同理。对某一个位置（0，j）来说，如果str1[0] == str2[j],令
 * dp[0][j] = 1,否则令dp[0][j] = 0。
 * 3.其他位置按照从左到右，再从上到下来计算，dp[i][j]的值只能有两种情况。
 * 3.1如果str1[i] != str2[j]说明在必须把str1[i]和str2[j]作为公共子串的最后一个字符是不可能的，令
 * dp[i][j] = 0。
 * 3.2如果str1[i] == str[j]说明str1[i]和str2[j]可以作为公共子串最后一个字符，从最后一个字符能向
 * 左扩多大的长度呢？就是dp[i-1][j-1]的值，所以令dp[i][j] = dp[i-1][j-1]+1。
 */

/**
 * 生成动态规划表之后，得到最长公共子串是非常容易的。
 */
public class LongestPublicCharacterString {
    public static int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        for(int i = 0; i < str1.length; i++){
            if(str1[i] == str2[0]){
                dp[i][0] = 1;
            }
        }
        for(int j = 0; j < str2.length; j++){
            if(str2[j] == str1[0]){
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < str1.length; i++){
            for(int j = 1; j < str2.length; j++){
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    public  static String lcst1(String str1, String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1,chs2);
        int end = 0;
        int max = 0;
        for(int i = 0; i < chs1.length; i++){
            for(int j = 0; j < chs2.length; j++){
                if(dp[i][j] > max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end  + 1);
    }

    public static void main(String[] args) {
        String str1 = "abcbcbbc";
        String str2 = "cbcbaaa";
        System.out.println(lcst1(str1, str2));
    }
}
