package org.muzhe.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-12 上午9:46.
 */
public class SortArrayByParity905Test {

    SortArrayByParity905 sortArrayByParity905 = new SortArrayByParity905();

    @Test
    public void sortArrayByParity() {
        int[] A = new int[]{3, 1, 2, 4};
        int[] ints = sortArrayByParity905.sortArrayByParity(A);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}