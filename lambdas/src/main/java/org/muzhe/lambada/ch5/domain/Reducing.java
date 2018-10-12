package org.muzhe.lambada.ch5.domain;

import org.muzhe.lambada.ch4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author muzhe-wang on  18-10-12 下午3:32.
 */
public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        System.out.println(" ------------------------------------------------------------------------------------------ ");

        handleReducingBiFunctionBinaryOperator();

        System.out.println(" ------------------------------------------------------------------------------------------ ");

        handleReducingSum(numbers);

        System.out.println(" ------------------------------------------------------------------------------------------ ");

        handleIntegerSum(numbers);

        System.out.println(" ------------------------------------------------------------------------------------------ ");

        handleIntegerMax(numbers);

        System.out.println(" ------------------------------------------------------------------------------------------ ");

        handleSumCalories(Dish.menu);

    }

    /**
     * 处理当前menu中卡路里的和
     *
     * @param menu
     */
    private static void handleSumCalories(List<Dish> menu) {

        Integer sumCalories = menu
                .stream()
                .map(dish -> dish.getCalories())
                .reduce(0, (a, b) -> a + b);

        System.out.println(sumCalories);
    }

    /**
     * 获取到numbers中的最大值
     *
     * @param numbers
     */
    private static void handleIntegerMax(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        System.out.println(max.get());

    }

    /**
     * 使用Integer中的sum对象。
     *
     * @param numbers
     */
    private static void handleIntegerSum(List<Integer> numbers) {

        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * 使用reduce来秋去number的和
     *
     * @param numbers
     */
    private static void handleReducingSum(List<Integer> numbers) {

        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a + b);

        System.out.println(reduce.get());

    }

    private static void handleReducingBiFunctionBinaryOperator() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        ArrayList<Integer> result = integers.stream().reduce(new ArrayList<Integer>(),
                new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                    /**
                     * 这里有三个参数，第一个是初始化的值，这个值是reduce中的第一个参数，这个是我们初始化定义的，
                     * 同时这个参数也会作为执行过程中，上一次的执行结果作为第一个参数进行下一个计算过程。
                     * @param acc
                     * @param num
                     * @return
                     */
                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer num) {

                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>handle the num " + num);
                        acc.add(num * 2);
                        return acc;

                    }
                },
                new BinaryOperator<ArrayList<Integer>>() {
                    //为什么这个BinaryOperator方法没有执行，这个原因是这个方法是用来并发执行的。
                    // 在单线程是不会被执行的。

                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> last) {
                        System.out.println(" ********************************************* the acc =  " + acc +
                                " the last = " + last);

                        acc.addAll(last);
                        return acc;
                    }
                });

        result.forEach(System.out::println);

    }

    /**
     * 使用redicuing的BiFunction的使用手法。这里可以研究一下，这个是如何实现的。
     */
    private static void handleReducingBiFunction() {

        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
                .reduce(new ArrayList<Integer>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
                                acc.add(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("BiFunction");
                                return acc;
                            }
                        }, new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                                System.out.println("BinaryOperator");
                                acc.addAll(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("--------");
                                return acc;
                            }
                        });
        System.out.println("accResult_: " + accResult_);

    }
}
