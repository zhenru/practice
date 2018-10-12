package org.muzhe.lambada.ch5;

import org.muzhe.lambada.ch4.Dish;

import java.util.Optional;

/**
 * @author muzhe-wang on  18-10-11 上午9:36.
 */
public class Finding {

    public static void main(String[] args) {

        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian Friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(dish1 -> System.out.println(dish1.getName()));
    }

    /**
     * 返回一个是蔬菜的　Dish对象
     * 这个方法使用了Filter，这个filter方法的参数是一个Predicate，如果Predicate返回的是一个true就会将对应对象添加到　返回的结果。
     * 然后使用findAny，这个对象将会将会将结果写到一个Optional对象中。因为结果中可能会有值，也可能没有值。
     * @return
     */
    private static Optional<Dish> findVegetarianDish() {
        return Dish.menu.stream().filter(Dish::isVegetarian).findAny();
    }

    /**
     * 可以使用allMatch的反方法nonMatch,在当前Stream中没有一个满足
     *
     * @return
     */
    private static boolean isHealthyMenu2() {

        return Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);

    }

    /**
     * 是否所有的菜品的卡路里都小于１０００
     * <p>
     * 使用　allMatch　 只要有一个Predicate返回的值为假，这个返回的结果就是false
     * 这个方法中有一个　Predicate　的方法。
     *
     * @return
     */
    private static boolean isHealthyMenu() {
        return Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
    }

    /**
     * 判断菜单中是否包括了蔬菜
     * 　　使用　anyMatch　来判断　只要有一个满足就返回　true.
     *
     * @return
     */
    private static boolean isVegetarianFriendlyMenu() {
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }

}
