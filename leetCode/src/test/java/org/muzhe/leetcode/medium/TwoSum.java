package org.muzhe.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author muzhe-wang on  18-10-12 下午6:07.
 */
public class TwoSum {

    @Test
    public void testTwoSum(){

        int[] numbers = new int[]{1,2,3,2,-1,-3};
        Arrays.sort(numbers);

        int start = 0;
        int end = numbers.length-1;

        while (start < end){
            int sum = numbers[start] + numbers[end];
            if (sum>0){
                end--;
            }else if (sum < 0){
                start++;
            }else {
                System.out.println(numbers[start] + " " + numbers[end]);
                start++;
                end--;
            }
        }
    }
}
