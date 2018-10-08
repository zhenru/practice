package org.muzhe.leetcode.easy;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-2 下午3:59.
 */
public class IsPowerOfTwo231Test {

    private IsPowerOfTwo231 isPowerOfTwo231 = new IsPowerOfTwo231();

    @Test
    public void isPowerOfTwo() {
        boolean powerOfTwo = isPowerOfTwo231.isPowerOfTwo(2);
        Assert.assertTrue(powerOfTwo);
    }

    @Test
    public void isPowerOfTwo2312() {

        boolean powerOfTwo = isPowerOfTwo231.isPowerOfTwo(1);
        Assert.assertTrue(powerOfTwo);
    }

    @Test
    public void isPowerOfTwo2313() {

        boolean powerOfTwo = isPowerOfTwo231.isPowerOfTwo(32);
        Assert.assertTrue(powerOfTwo);
    }

    @Test
    public void isPowerOfTwo2314() {

        boolean powerOfTwo = isPowerOfTwo231.isPowerOfTwo(218);
        Assert.assertFalse(powerOfTwo);
    }
}