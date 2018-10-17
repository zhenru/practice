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
            //这里是用来处理当前对象中需要将相同的元素给过滤掉的实现。
            if (i != 0 && nums[i] == nums[i-1]){
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
     * @param nums          数值序列
     * @param start
     * @param end
     * @param sum
     * @return
     */
    protected List<List<Integer>> twoSum(int[] nums, int start, int end, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            int localSum = nums[start] + nums[end];
            if (localSum == sum) {
                List<Integer> local = new ArrayList<>();
                local.add(nums[start]);
                local.add(nums[end]);
                result.add(local);
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
