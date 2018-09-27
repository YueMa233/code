package com.ma.characterString;

/**
 * 题目：
 * 给定一个字符串str，求其全部数字串所代表的数字之和
 * 要求：
 * 1.忽略小数点字符，例如"A1.3"，其中包含数字1和3。
 * 2.如果紧贴数字子串左边出现字符"-"，当连续出现的数量为奇数时，则数字视为负，连续出现视为数量为偶数时，则数字
 * 视为正。例如："A-1BC--12"，其中包含数字为-1和12。
 */

/**
 * 举例：
 * str = "A1CD2E33"，返回36。
 * str = "A-1B"-2C--D6E,返回7。
 */

import com.sun.jmx.snmp.internal.SnmpSubSystem;

/**
 * 解答：
 * 1.生成三个变量。整型变量res，表示目前额累加和；整型变量num,表示当前收集到的数字；布尔型变量posi，表示如果将num
 * 累加到res里面，num是正还是负。初始时候res=0，num=0,posi=true。
 *
 * 2.从左到右遍历str，假设遍历字符cha，根据具体的cha有不同的处理。
 *
 * 3.如果cha是'0-9',cha-'a'的值记为cur，假设之前收集的数字为num，此时举例说明。比如str='123'，初始时num=0，posi
 * =true。当cha=='1'时num变为1；cha=='2'时，num变为12；cha=='3'时num变为123。再如str="-123",初始时num=0,posi=true
 * 当cha='-'时，posi变为false,cha不是'0-9'的情况接下来会说明，num=num*10+(posi?cur:-cur)。
 *
 * 4.如果cha不是'0-9',此时不管cha具体是什么，都是累加时，令res+=num然后令num=0,累加完后num当然要清零。累加完成后
 * 再看cha的具体情况。如果cha不是字符'-',令posi=true，即如果cha既不是数字字符，也不是'-'字符，posi都变为true。
 * 如果cha是字符'-'，此时看cha的前一个字符，如果前一个字符也是'-'则posi改变符号，即posi=!posi；否则令posi=false。
 *
 * 5.既然我们把累加的时机放到了cha不是数字字符的时候，那么如果str是以数字字符结尾的，会出现在最后一个数字没有累加的
 * 情况。所以遍历完成后令res+=num，防止最后的数字累加不上的情况发生。
 *
 * 6.最后返回res。
 */
public class Digitalsummation {
    public static int numSum(String str){
        if(str == null){
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;//目前累加和
        int num = 0;//整型变量
        boolean posi = true;//num为正还是为负
        int cur = 0;//当前变量
        for(int i = 0; i < charArr.length; i++){
            cur = charArr[i] - '0';
            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(charArr[i] == '-'){
                    if(i - 1 > -1 && charArr[i - 1] == '-'){
                        posi = !posi;
                    }
                }else{
                    posi = true;
                }
            }else{
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }
    public static void main(String[] args) {
        String str = "A1CD2E33";
        System.out.println(numSum(str));
    }
}
