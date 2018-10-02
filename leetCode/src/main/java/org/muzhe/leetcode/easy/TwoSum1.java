package org.muzhe.leetcode.easy;

/**
 * @see <a href="https://leetcode-cn.com/problems/two-sum/description/">https://leetcode-cn.com/problems/two-sum/description/</a>
 *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 *  示例:
 *
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 *
 * @author muzhe-wang on  18-10-2 下午2:21.
 */
public class TwoSum1 {

    /**
     * 给定一个数组nums，找出两个数的和=target的下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0 ; i< nums.length;i++){
            for (int j = i+1;j< nums.length;j++){
                if (nums[i]+ nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
