package org.muzhe.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-17 下午12:25.
 */
public class ThreeSumClosest16Test {

    private ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();

    @Test
    public void threeSumClosest() {

        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest16.threeSumClosest(nums, target);
        System.out.println(result);
    }
}