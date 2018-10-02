package org.muzhe.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-10-2 下午2:54.
 */
public class Reverse7Test {

    private Reverse7 reverse7 = new Reverse7();

    @Test
    public void reverse() {
        int reverse = reverse7.reverse(123);
        System.out.println(reverse);
        Assert.assertEquals(reverse, 321);
    }

    @Test
    public void reverse2() {

        int reverse = reverse7.reverse(-123);
        Assert.assertEquals(-321, reverse);
    }

    @Test
    public void reverse3() {

        int reverse = reverse7.reverse(120);
        Assert.assertEquals(reverse, 21);
    }

    @Test
    public void reverse4(){

        int reverse = reverse7.reverse(1534236469);
        System.out.println(reverse);

    }

    @Test
    public void reverse5(){

        int reverse = reverse7.reverse(-1563847412);
        System.out.println(reverse);
    }


    @Test
    public void testReverse(){

        Long base =1000000000L;
        int count = 9;
        System.out.println(base*count);
    }

    @Test
    public void testIntegerMax(){

        System.out.println(Integer.MAX_VALUE);
    }

}