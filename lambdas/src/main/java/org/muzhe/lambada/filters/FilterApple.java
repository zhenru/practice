package org.muzhe.lambada.filters;

import com.google.common.collect.Lists;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author muzhe-wang on  18-10-8 下午6:02.
 */
public class FilterApple {

    private static final String GREEN = "G";
    private static final String RED = "R";
    private static final String YELLOW = "Y";

    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple(80, GREEN),
                new Apple(155, YELLOW),
                new Apple(230, RED));

        List<Apple> colorFilterResult = filterApple(appleList, FilterApple::isGreenApple);
        System.out.println(colorFilterResult);
        List<Apple> colorFilterResult2 = filterApple(appleList, (Apple apple) -> apple.color.equals(GREEN));
        System.out.println(colorFilterResult2);

        List<Apple> heavyFilterResult = filterApple(appleList, FilterApple::isHeavyApple);
        System.out.println(heavyFilterResult);
        List<Apple> heavyFilterResult2 = filterApple(appleList, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(heavyFilterResult2);

        List<Apple> mergeFilterResult = filterApple(appleList, (Apple apple) -> apple.getColor().equals(YELLOW) || apple.getWeight() > 140);
        System.out.println(mergeFilterResult);

    }

    /**
     * 过滤出所有苹果中颜色为绿色的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory) {
            if (apple.color.equals(GREEN)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static final boolean isHeavyApple(Apple apple) {
        return 150 < apple.getWeight();
    }

    /**
     * 过滤掉重量的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterWeightApple(List<Apple> inventory) {

        List<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> applePredicate) {
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    @Data
    @AllArgsConstructor
    public static class Apple {

        private int weight;

        private String color;
    }
}
