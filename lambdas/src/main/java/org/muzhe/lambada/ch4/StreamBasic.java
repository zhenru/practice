package org.muzhe.lambada.ch4;

import com.google.common.collect.Lists;

import javax.swing.plaf.basic.BasicListUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-10-9 下午1:01.
 */
public class StreamBasic {

    public static void main(String[] args) {

        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("-----------------");
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> menu) {
        return menu.stream()
                //filter是对当前的list进行过滤
                .filter((Dish dish) -> dish.getCalories() < 400)
                //sort是对当前队列进行排序。
                .sorted((Dish dish1, Dish dish2) -> dish1.getCalories() - dish2.getCalories())
                //map调用一个Ｆunction，对当前对象进行处理
                .map(dish -> dish.getName())
                //将stream转换为一个List
                .collect(Collectors.toList());
    }

    /**
     * 获取到到menu中的所有的卡路里小于400，同时按照卡路里升序排序，同时返回对应的菜的名称
     *
     * @param menu
     * @return
     */
    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> menu) {
        List<Dish> lowCaloricDishes = Lists.newArrayList();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        List<String> lowCaloricDishName = Lists.newArrayList();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishName.add(dish.getName());
        }
        return lowCaloricDishName;
    }
}
