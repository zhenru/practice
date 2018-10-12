package org.muzhe.lambada.ch5;

import org.muzhe.lambada.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-10-11 上午9:56.
 */
public class Mapping {
    public static void main(String[] args) {

        //获取到菜单中所有菜品的名称
        List<String> dishNames = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());

        System.out.println(dishNames);
        System.out.println(" ----------------------------------------------------------------- ");

        //统计每一个字符串的长度
        List<String> strings = handleMap();
        System.out.println(" ----------------------------------------------------------------- ");

        //使用flatMap来处理　String，这个不太熟悉，可以后面看一下
        handleFlatMap(strings);
        System.out.println(" ----------------------------------------------------------------- ");

        handleFlatMap2();


    }

    /**
     * 处理flatMap，看一下flatmap是如何实现的。
     * 这里的实现是将大哥你去哪的对象作为一个交集
     * todo java8中的　flatMap实现还是有一些复杂的。 muzhe
     */
    private static void handleFlatMap2() {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = numbers1.stream().flatMap((Integer i) -> numbers2.stream().map((Integer j) -> new int[]{i, j}))
//                .filter(pair -> ((pair[0] + pair[1]) % 3 == 0))
                .collect(Collectors.toList());
        pairs.forEach(pair ->System.out.print("(" + pair[0] + "," + pair[1] + ")"));
    }

    private static List<String> handleMap() {
        List<String> strings = Arrays.asList("Hello", "World");
        List<Integer> stringLength = strings.stream().map(string -> string.length()).collect(Collectors.toList());
        System.out.println(stringLength);
        return strings;
    }

    /**
     * 处理flatMap的实现
     * @param strings
     */
    private static void handleFlatMap(List<String> strings) {
        strings.stream().flatMap((String line) -> Arrays.stream(line.split(""))).distinct().forEach(System.out::println);
    }
}
