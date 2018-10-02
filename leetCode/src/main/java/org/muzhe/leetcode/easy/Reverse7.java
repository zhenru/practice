package org.muzhe.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-2 下午2:53.
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer/description/">https://leetcode-cn.com/problems/reverse-integer/description/</a>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse7 {
    /**
     * 这里的实现方法是当前的数值的每一位都记录下来，然后最后使用long类型来比较溢出的情况
     *
     * @param x
     * @return
     */
//    public int reverse(int x) {
//
//        if (x == 0) {
//            return 0;
//        }
//        boolean isNegative = x < 0;
//        if (x < 0) {
//            x = x * -1;
//        }
//
//        List<Integer> counts = new ArrayList<Integer>();
//        while (x > 0) {
//            counts.add(x % 10);
//            x = x / 10;
//        }
//        Long result = 0L;
//        long base = 1L;
//        boolean isStartZero = true;
//        for (int i = counts.size() - 1; i >= 0; i--) {
//            if (counts.get(i) == 0 && isStartZero) {
//                continue;
//            } else {
//                long iResult = counts.get(i) * base;
//                result += iResult;
//                base *= 10;
//                isStartZero = false;
//            }
//        }
//
//        if (isNegative) {
//            result *= -1;
//            if (result.compareTo(Long.valueOf(Integer.MIN_VALUE)) <0){
//                return 0;
//            }else {
//                return result.intValue();
//            }
//        }
//
//        if (result.compareTo(Long.valueOf(Integer.MAX_VALUE)) >0){
//            return 0;
//        }
//        return result.intValue();
//    }

    /**
     * 将数值进行反转的方法类似与链表反转，可以将每一个都插入到链表头部，也可以将所有的值写到链表的尾部。
     * @param x
     * @return
     */
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int sign = x > 0 ? 1 : -1;

        x =Math.abs(x);
        long result =0;
        while (x!=0){

            result = result*10 + x%10;
            x  /=10;
        }

        if (result >Integer.MAX_VALUE){
            return 0;
        }
        return sign * (int)result;
    }
}
