package org.muzhe.leetcode.easy;

/**
 * @author muzhe-wang on  18-10-2 下午3:59.
 */
public class IsPowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {

        if (n<=0){
            return false;
        }

        while (n!=1){
            if (n%2!=0){
                return false;
            }
            n = n/2;
        }
        return true;
    }
}
