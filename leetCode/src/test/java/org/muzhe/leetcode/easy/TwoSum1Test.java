package org.muzhe.leetcode.easy;

import org.junit.Test;
import ort.muzhe.leetcode.LUtil;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-2 下午2:25.
 */
public class TwoSum1Test {

    private TwoSum1 twoSum1 = new TwoSum1();


    @Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] results = twoSum1.twoSum(nums, target);
        LUtil.display(results);
    }
}