package org.muzhe.lambada.ch5;

import org.muzhe.lambada.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream的过滤功能
 * @author muzhe-wang on  18-10-10 下午5:48.
 */
public class Filtering {

    public static void main(String[] args) {

        //将所有的蔬菜从整个队列中筛选出来
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        vegetarianMenu.forEach(System.out::println);

        System.out.println(" --------------------------------------------------------  ");
        handleFilterList();

        System.out.println(" ---------------------------------------------------------  ");

        handleStreamLimit();
        System.out.println(" ---------------------------------------------------------  ");
        handleStreamSkip();
    }

    /**
     * 处理跳跃的数据
     * skip 是跳过序列前面的几个的值
     */
    private static void handleStreamSkip() {

        Dish.menu.forEach(System.out:: println);

        List<Dish> skipDish = Dish.menu.stream().filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("  =============================== ");
        skipDish.forEach(System.out::println);


    }

    private static void handleStreamLimit() {
        Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted((Dish dish1, Dish dish2) -> dish1.getCalories() - dish2.getCalories())
                .limit(2)
                .forEach(System.out::println);
    }

    /**
     * 处理系统中的相同的数
     */
    private static void handleFilterList() {

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0)
                //distinct是将当前系统中不同的数据进行删除
                .distinct()
                .forEach(System.out::println);
    }


}
