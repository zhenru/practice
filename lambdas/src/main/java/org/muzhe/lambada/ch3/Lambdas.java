package org.muzhe.lambada.ch3;

import com.google.common.collect.Lists;
import lombok.Data;
import org.muzhe.lambada.common.Apple;
import org.muzhe.lambada.common.Common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-8 下午6:22.
 */
public class Lambdas {


    public static void main(String[] args) {

        Runnable r = ()-> System.out.println("hello!");
        r.run();

        List<Apple> apples = Common.generateAppleList();
        List<Apple> colorFilterAppleList = filterApples(apples, (Apple apple) -> Common.YELLOW.equals(apple.getColor()));
        System.out.println(colorFilterAppleList);

        Comparator<Apple> heavyComparator = ((Apple first , Apple second) ->-1 * Integer.valueOf(first.getWeight()) .compareTo(second.getWeight())) ;

        apples.sort(heavyComparator);
        System.out.println(apples);

    }

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> appleResult = Lists.newArrayList();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                appleResult.add(apple);
            }
        }
        return appleResult;
    }


    interface ApplePredicate {
        boolean test(Apple apple);
    }
}
