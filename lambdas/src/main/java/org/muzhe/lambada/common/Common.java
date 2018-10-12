package org.muzhe.lambada.common;

import com.google.common.collect.Lists;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-8 下午6:26.
 */
public class Common {

    public static String YELLOW = "yellow";

    public static String RED = "red";

    public static String BROWN = "brown";

    public static String BLACK = "black";


    /**
     * 构造一个苹果列表
     *
     * @return
     */
    public static final List<Apple> generateAppleList() {

        List<Apple> appleList = Arrays.asList(
                new Apple(155, RED),
                new Apple(40, YELLOW),
                new Apple(240, BLACK));
        return appleList;
    }

}
