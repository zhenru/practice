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


    @Test
    public void testThreeSum(){
        int[]   numbers = new int[]{-2,0,0,2,2};
        List<List<Integer>> lists = threeSum15.threeSum(numbers);
        System.out.println(lists);
    }

    @Test
    public void testTwoSum(){

        int[] numbers = new int[]{0,0,2,2};
        List<List<Integer>> lists = threeSum15.twoSum(numbers, 0, numbers.length - 1, 2);
        System.out.println(lists);
    }


}