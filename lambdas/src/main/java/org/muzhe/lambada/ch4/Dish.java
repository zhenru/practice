package org.muzhe.lambada.ch4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * @author muzhe-wang on  18-10-9 下午12:54.
 */
@AllArgsConstructor
@Getter
@ToString
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;


    public enum Type {
        MEAT, FISH, OTHER
    }

    public static final List<Dish> menu = Arrays.asList(
            new Dish("port", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 400, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH));
}
