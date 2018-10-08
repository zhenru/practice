package org.muzhe.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @see　<a href="https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/description/">https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/description/</a>
 * @author muzhe-wang on  18-10-2 下午4:09.
 */
public class CanPartitionKSubsets698 {

    /**
     * 给定一个数组　nums,然后给定一个数k.看能否将　数组分为k个集合，其中每个集合中的和是相等的。
     * @param nums          给定一个数组
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        Map<Integer ,Integer> valueCount = new HashMap<Integer,Integer>();
        int sum = 0;
        for (int num : nums){
            sum += num;
            if (valueCount.containsKey(num)){
                valueCount.put(num,valueCount.get(num)+1);
            }else {
                valueCount.put(num,1);
            }
        }

        if (sum%k != 0){
            return false;
        }

        //todo 这个算法使用动态规划来实现，后面需要单独的实现，现在不太熟悉如何实现这个算法 muzhe

        int target = sum/k;



        return false;
    }
}
