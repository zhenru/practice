package org.muzhe.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-12 下午5:08.
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {


        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = 0 - nums[i];
            List<List<Integer>> lists = twoSum(nums, i + 1, nums.length - 1, sum);
            for (List<Integer> localResult : lists) {
                localResult.add(nums[i]);
                result.add(localResult);
            }
        }
        return result;

    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            int localSum = nums[start] + nums[end];
            if (localSum == sum) {
                result.add(Arrays.asList(nums[start], nums[end]));
                start++;
                end--;
            } else if (localSum > sum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
