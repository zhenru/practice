package org.muzhe.lambada.ch5;

import org.muzhe.lambada.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author muzhe-wang on  18-10-11 下午12:46.
 */
public class NumbericStreams {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        System.out.println(" ------------------------------------------------------------------");

        handMapToInt();
        System.out.println(" ------------------------------------------------------------------");

        //找出当前菜单中的卡路里最大的那道菜品的卡路里数
        handleGetMaxMenuCalories();
        System.out.println(" ------------------------------------------------------------------");

        //处理一下int的区间,
        handleIntStream();
        System.out.println(" ------------------------------------------------------------------");

        handleIntStream2();
    }

    private static void handleIntStream2() {
//todo　　这里需要理解一下flatMap是如何实现的。
//        Stream<Integer> boxed = IntStream.rangeClosed(1, 100)
//                .boxed().flatMap(a->IntStream.rangeClosed(a,100).filter(b->Math.sqrt(a*a+b*b)%1 == 0).boxed().map(b -> new int[] {a,b,(int)Math.sqrt(a*a+b*b)}));
    }

    /**
     * 处理int的区间的数据
     * 通过IntStream.rangeClosed()获取到　一个数值的区间，这个区间返回的是一个IntStream。然后对正常Stream进行处理
     */
    private static void handleIntStream() {
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(intStream.count());

    }

    private static void handleGetMaxMenuCalories() {
        OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        if (maxCalories.isPresent()) {
            System.out.println(maxCalories.getAsInt());
        } else {
            System.out.println(0);
        }
        System.out.println(maxCalories.orElse(0));
    }

    /**
     * 可以将一个List中对象中的一些属性给通过map给抽取出来，然后调用sum来计算出总的和。
     */
    private static void handMapToInt() {

        int sumCalories = Dish.menu
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println(" sum calories of the menu " + sumCalories);


    }
}
