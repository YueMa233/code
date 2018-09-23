package com.ma.characterString;

/**
 *  题目：
 *  给定一个字符串 str，返回 str 最长无重复子串的长度。
 *  举例：
 *  str = "abcd" 返回 4
 *  str = "aabcb",最长无重复子串为"abc"，返回3。
 */

/**
 * 解答：
 * 如果 str 长度为 N,字符编码范围是M,本题可以做到时间复杂度为O(N),额外空间复杂度为O(M)。
 *
 * 1.在遍历str之前，先申请几个变量。哈希表 map，key表示某个字符，value为这个字符第一次出现的位置。
 * 整型变量pre,如果当前遍历到字符str[i],pre表示必须以str[i - 1]字符结尾的情况下，最长无重复子串
 * 开始位置的前一个位置，初始时pre = -1。整型变量len,记录每一个字符结尾的情况下，最长无重复子串
 * 长度的最大值，初始时，len = 0。从左到右遍历字符串str,假设现在遍历到str[i],接下来求必须以str[i]
 * 结尾的情况下，最长无重复子串的长度。
 *
 * 2.map(str[i])的值表示之前遍历中最近一次出现str[i]的位置，假设在a位置。想要求以str[i]结尾的最长无
 * 重复子串，a位置必然不能包含进来，因为str[a]等于str[i]。
 *
 * 3.根据pre的定义，pre + 1 表示必须以str[i -  1]字符结尾的情况下，最长无重复子串开始的位置，假设在
 * a位置，也就是说，以str[i -1 ]结尾的最长无重复子串是向左扩展到pre位置才停止的。
 *
 * 4.如果pre的位置在a的左边，因为str[a]的位置是不能包含进来的，而str[a+1...i-1]上是不重复的，所以
 * 以str[i]结尾的最长无重复子串就是str[a+1...i]。如果pre的位置在a的右边，以str[i]结尾的最长无重复子串
 * 是向左扩充到pre结束的。所以以str[i]结尾的最长无重复子串扩充到pre也会停止，而且str[pre+1... i-1]
 *上肯定不含有str[i],s所以以str[i]结尾的最长无重复子串就是str[pre+1...i]
 *
 * 5.计算完长度后，pre位置和a位置哪一个在右边哪一个就作为新的pre值。然后计算下一个pre的值。所有长度
 * 的最大值用len记录。
 */
public class Longestnonrepeatingsubstring {
    public static int maxUnique(String str){
        if(str == null || str == ""){
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }
        int pre = -1;
        int cur = 0;
        int len = 0;
        for(int i = 0; i != chas.length; i++ ){
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        String str = new String("abcabcdebc");
        System.out.println(maxUnique(str));

    }
}
