package org.muzhe.leetcode.easy;

import com.sun.xml.internal.ws.util.xml.StAXResult;

/**
 * @author muzhe-wang on  18-10-12 上午9:44.
 */
public class SortArrayByParity905 {

    /**
     * 给定一个非负的数组A,返回一个由A的所有偶数组成的数组，后面跟着所有的奇数元素。
     * 给定一个数组，将数组的左边全部是偶数，后面全部是奇数。
     * 使用一个类似快速排序partion的方法，将偶数放在左边，将奇数放在右边
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        partion(A, 0, A.length);
        return A;
    }

    /**
     * 将a[start,end)的数组分为左边为偶数，右边为奇数的实现。这个可以使用快速排序的实现。
     *
     * @param a
     * @param start
     * @param end
     */
    private void partion(int[] a, int start, int end) {

        int ouIndexNext = start;
        while (start < end) {
            if (a[start] % 2 == 0) {
                swap(a, ouIndexNext, start);
                ouIndexNext++;
            }
            start++;
        }
    }

    private void swap(int[] a, int index1, int index2) {

        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
