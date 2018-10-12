package org.muzhe.leetcode.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-12 下午5:09.
 */
public class ThreeSum15Test {

    private ThreeSum15 threeSum15 = new ThreeSum15();

    @Test
    public void threeSum() {
        int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = threeSum15.threeSum(numbers);
        System.out.println(resultList);
    }
}