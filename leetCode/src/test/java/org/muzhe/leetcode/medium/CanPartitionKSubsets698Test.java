package org.muzhe.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-2 下午4:12.
 */
public class CanPartitionKSubsets698Test {

    private CanPartitionKSubsets698 canPartitionKSubsets698 = new CanPartitionKSubsets698();

    @Test
    public void canPartitionKSubsets() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean b = canPartitionKSubsets698.canPartitionKSubsets(nums, k);
        Assert.assertTrue(b);
    }

    @Test
    public void canPartitionKSubsets1(){

    }
}