package org.muzhe.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 在一个排序的算法中是如何进行去从的呢？
 * 在排序的数组中，如果存在相同的数，这些数值将会连续的存放在数组中，如果需要忽略相同的数值，那么负责处理逻辑的将是第一个元素，然后使用一个while将所有的相同的元素都给忽略掉，知道第一个元素为止。
 * 但是在排除万相同元素后需要对当前元素的范围进行校验，因为这个过程可能会越界
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
            //这里是用来处理当前对象中需要将相同的元素给过滤掉的实现。
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = 0 - nums[i];
            List<List<Integer>> lists = twoSum(nums, i + 1, nums.length - 1, sum);
            for (List<Integer> localResult : lists) {
                localResult.add(nums[i]);
                result.add(localResult);
            }
        }
        return result;

    }

    /**
     * 在nums 数组中 [start,end]中的两个数的和等于sum的所有的序列对，其中需要去重
     * 　这个当中如何去重的。
     *
     * @param nums  数值序列
     * @param start
     * @param end
     * @param sum
     * @return
     */
    protected List<List<Integer>> twoSum(int[] nums, int start, int end, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        int i = start, j = end;
        while (i < j) {
            while (i > start && i<end && nums[i] == nums[i - 1]) {
                i++;
            }
            while (j < end && j>end&& nums[j] == nums[j + 1]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int localSum = nums[i] + nums[j];
            if (localSum == sum) {
                List<Integer> local = new ArrayList<>();
                local.add(nums[i]);
                local.add(nums[j]);
                result.add(local);
                i++;
                j--;
            } else if (localSum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
